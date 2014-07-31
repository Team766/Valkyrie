package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.PIDController;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;
/**
 * Command to move forward a preset distance.
 * However, on top of moving a distance, this command uses a 
 * second PID to keep the robot going straight.
 * 
 *
 * @author Nicky Ivy nickivyca@gmail.com
 */
public class DriveStraightCommand extends CommandBase {
	
	private PIDController DistancePID = new PIDController(RobotValues.AngleKp, RobotValues.AngleKi,
			RobotValues.AngleKd, RobotValues.Angleoutputmax_low, RobotValues.Angleoutputmax_high, 
			RobotValues.AngleThreshold); //see PID class or hover for definition of all
	
	private PIDController StraightPID = new PIDController(RobotValues.StraightKp, 
			RobotValues.StraightKi, RobotValues.StraightKd, RobotValues.Straightoutputmax_low,
			RobotValues.Straightoutputmax_high, RobotValues.StraightThreshold);
    
    public DriveStraightCommand() {
    	DistancePID.setSetpoint(0);
    	StraightPID.setSetpoint(0);
    }
    
    public DriveStraightCommand(double distance){
    	DistancePID.setSetpoint(distance);
    	StraightPID.setSetpoint(0); //we still want the different between both wheel speeds to be 0
    }
    
    protected void initialize() {
    	Drive.resetEncoders();
    	DistancePID.reset();
    	StraightPID.reset();
    	Drive.setShifter(false);
    }
    
    public void execute() {
    	DistancePID.calculate((Drive.getLeftDistance() + Drive.getRightDistance()) / 2.0);
    	StraightPID.calculate(Drive.getLeftSpeed() - Drive.getRightSpeed());
    	Drive.setLeftPower(DistancePID.getOutput() - StraightPID.getOutput());
    	Drive.setRightPower(DistancePID.getOutput() + StraightPID.getOutput());
    }
    
    protected boolean isFinished() {
        return DistancePID.isDone();
    }
    
    protected void end() {
        Drive.drive(0.0);
    }
    
    protected void interrupted() {
    	end();
    }
}
