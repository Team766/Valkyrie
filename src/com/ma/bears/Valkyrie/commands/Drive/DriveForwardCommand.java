/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;

import com.ma.bears.Valkyrie.subsystems.Drive;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;
/**
 * Command to move forward a preset distance.
 *
 * @author Blevenson
 */
public class DriveForwardCommand extends Command {
    private boolean done = false; 
    private double kDriveDistance;
    Drive drive = new Drive();
    
    public DriveForwardCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public DriveForwardCommand(double distance){
    	kDriveDistance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    public void execute() {
        //Reseting Encoders
	Valkyrie.Drive.resetEncoders();
	//Move forward 24 inches
	//const double kDriveDistance = dash->GetNumber("DriveDistance1Ball");
	//const double Kp = 10.0; //proportional constant  Real Number in robotvalues
	//const double Kd = 0.8;  //derivative constant           "   "
	double last_error = 0.0;
	// Kp, Kd from RobotValues.h
	while (!done) {
            final double error = kDriveDistance - (drive.getLeftDistance() + drive.getRightDistance()) / 2.0;
            final double drive_power = RobotValues.Kp * error + RobotValues.Kd * (error - last_error) * 100.0;
            Valkyrie.leftDrive.set(-drive_power);
            Valkyrie.rightDrive.set(drive_power);
            try {
            	wait((long) 0.02);
            } catch (InterruptedException e) {
            	System.out.println("Drive forward interrupted");
            	done = true;
            }
            System.out.println("error " + error + " drive_power " + drive_power + " ld " + drive.getLeftDistance() + " rd " + drive.getRightDistance() + "\n");
            last_error = error;
            // If at 0 +- tolerance, stop driving
            if (Math.abs(error) <= (0 + RobotValues.driveTolerance)){
                System.out.println("Break Drive To Distance \n");
                Valkyrie.leftDrive.set(0.0);  //use function in drive subsystem
                Valkyrie.rightDrive.set(0.0); //       "           "
                done = true;
                break;  //if in right spot, go to firing
            }
        }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
