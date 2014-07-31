package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;
/**
 * Command to turn preset distance.
 * 
 * <p>This class reads the gyro and turns the supplied
 * angle.  Used in auton.
 *
 * @author Blevenson
 */
public class GyroDriveCommand extends CommandBase {
    private boolean done = false; 
    private double kTurnAngle;
	private double last_error = 0.0;
    
    public GyroDriveCommand() {
    	kTurnAngle = 0;
    }
    
    public GyroDriveCommand(double angle){
    	kTurnAngle = -angle;
    }
    
    protected void initialize() {
        //Resetting everything
    	//Gets reset when auton is init
    	//Drive.resetGyro();
    	done = false;
    	last_error = 0.0;
    }
    
    public void execute() {
	// Kp, Kd from RobotValues
	if(!done) {
            final double error = kTurnAngle - Drive.getAngle();
            final double drive_power = RobotValues.Kp * error + RobotValues.Kd * (error - last_error) * 100.0;
            Drive.setLeftPower(drive_power);
            Drive.setRightPower(drive_power);
            new WaitCommand(0.02).start();
            System.out.println("Gyro error " + error + " drive_power " + drive_power + " ld " + Drive.getLeftDistance() + " rd " + Drive.getRightDistance() + "\n");
            last_error = error;
            // If at 0 +- tolerance, stop driving
            if (Math.abs(error) <= (0 + RobotValues.driveTolerance)){
                System.out.println("Break Turn To Distance \n");
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
        Drive.drive(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
