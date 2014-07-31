package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.PIDController;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;
/**
 * Command to turn a selected angle.
 * Uses 766 PID to control turning. 
 * (not WPI PID)
 * 
 *  At this moment the PID has *not* been tuned!
 *
 * @author Nicky Ivy nickivyca@gmail.com
 */
public class GyroTurnCommand extends CommandBase {
	private PIDController AnglePID = new PIDController(RobotValues.AngleKp, RobotValues.AngleKi,
			RobotValues.AngleKd, RobotValues.Angleoutputmax_low, RobotValues.Angleoutputmax_high, 
			RobotValues.AngleThreshold); //see PID class or hover for definition of all
    
    public GyroTurnCommand() {
    	AnglePID.setSetpoint(0);
    }
    
    public GyroTurnCommand(double angle){
    	AnglePID.setSetpoint(angle);
    }
    
    protected void initialize() {
    	Drive.resetGyro();
    	AnglePID.reset();
    }
    
    public void execute() {
    	AnglePID.calculate(Drive.getAngle());
    	Drive.setLeftSpeed(AnglePID.getOutput());
    	Drive.setRightSpeed(-AnglePID.getOutput());    
    }
    protected boolean isFinished() {
        return AnglePID.isDone();
    }
    protected void end() {
        Drive.setLeftSpeed(0.0);  //use function in drive subsystem
        Drive.setRightSpeed(0.0);
    }
    protected void interrupted() {
    	end();
    }
}
