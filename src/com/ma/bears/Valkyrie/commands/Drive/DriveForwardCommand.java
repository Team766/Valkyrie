/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;
import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;
/**
 * Command to move forward a preset distance.
 *
 * @author Blevenson
 */
public class DriveForwardCommand extends CommandBase {
    private boolean done = false; 
    private double kDriveDistance;
	double last_error = 0.0;
    
    public DriveForwardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	kDriveDistance = 0;
    }
    
    public DriveForwardCommand(double distance){
    	kDriveDistance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //Resetting everything
    	Drive.resetEncoders();
    	done = false;
    	last_error = 0.0;
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
	//Move forward 24 inches
	//const double kDriveDistance = dash->GetNumber("DriveDistance1Ball");
	//const double Kp = 10.0; //proportional constant  Real Number in robotvalues
	//const double Kd = 0.8;  //derivative constant           "   "
	// Kp, Kd from RobotValues.h
	if(!done) {
            final double error = kDriveDistance - (Drive.getLeftDistance() + Drive.getRightDistance()) / 2.0;
            final double drive_power = RobotValues.Kp * error + RobotValues.Kd * (error - last_error) * 100.0;
            Drive.setLeftSpeed(-drive_power);
            Drive.setRightSpeed(drive_power);
            new WaitCommand(0.02).start();
            System.out.println("error " + error + " drive_power " + drive_power + " ld " + Drive.getLeftDistance() + " rd " + Drive.getRightDistance() + "\n");
            last_error = error;
            // If at 0 +- tolerance, stop driving
            if (Math.abs(error) <= (0 + RobotValues.driveTolerance)){
                System.out.println("Break Drive To Distance \n");
                done = true;
            }
        }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
        Drive.setLeftSpeed(0.0);  //use function in drive subsystem
        Drive.setRightSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
