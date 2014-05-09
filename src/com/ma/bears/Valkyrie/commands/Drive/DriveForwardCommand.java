/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Drive;

import edu.wpi.first.wpilibj.command.Command;
import com.ma.bears.Valkyrie.Valkyrie;
/**
 *
 * @author Blevenson
 */
public class DriveForwardCommand extends Command {
    public static boolean done = true; 
    
    public DriveForwardCommand(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*
        //Reseting Encoders
	Valkyrie.LDriveEnc.reset();
	Valkyrie.RDriveEnc.reset();
	//Move forward 24 inches
	//const double kDriveDistance = dash->GetNumber("DriveDistance1Ball");
	//const double Kp = 10.0; //proportional constant  Real Number in robotvalues
	//const double Kd = 0.8;  //derivative constant           "   "
	double last_error = 0.0;
	// Kp, Kd from RobotValues.h
	while (IsAutonomous() && isEnabled()) {
            const double error = kDriveDistance - (left_distance() + right_distance()) / 2.0;
            const double drive_power = Kp * error + Kd * (error - last_error) * 100.0;
            LeftDrive.SetSpeed(-drive_power);
            RightDrive.SetSpeed(drive_power);
            Wait(0.02);
            System.out.println("error %f drive_power %f ld %f rd %f\n", error, drive_power, left_distance(), right_distance());
            last_error = error;
            // If at 0 +- tolerance, stop driving
            if (fabs(error) <= (0 + driveTolerance)){
                printf("Break Drive To Distance \n");
                LeftDrive.SetSpeed(0);
                RightDrive.SetSpeed(0);
                break;  //if in right spot, go to firing
            }
        }
    */
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
