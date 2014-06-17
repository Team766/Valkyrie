package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;
/**
 * Command to move forward a preset distance.
 * 
 * <p>Note that the front of the robot
 * is the pickup side. That's why all the auton distances
 * are negative; it needs to drive 'backwards'
 * to achieve its distances. 
 *
 * @author Blevenson
 */
public class DriveForwardCommand extends CommandBase {
    private boolean done = false; 
    private double kDriveDistance;
	private double last_error = 0.0;
    
    public DriveForwardCommand() {
    	kDriveDistance = 0;
    }
    
    public DriveForwardCommand(double distance){
    	kDriveDistance = distance;
    }
    
    protected void initialize() {
        //Resetting everything
    	Drive.resetEncoders();
    	done = false;
    	last_error = 0.0;
    }
    
    public void execute() {
	// Kp, Kd from RobotValues
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
