package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.PIDController;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	//private PIDController AnglePID = new PIDController(RobotValues.AngleKp, RobotValues.AngleKi,
	//		RobotValues.AngleKd, RobotValues.Angleoutputmax_low, RobotValues.Angleoutputmax_high, 
	//		RobotValues.AngleThreshold); //see PID class or hover for definition of all
        private PIDController AnglePID = new PIDController(SmartDashboard.getNumber("AngleKp"),
                SmartDashboard.getNumber("AngleKi"),
                        SmartDashboard.getNumber("AngleKd"),RobotValues.Angleoutputmax_low, RobotValues.Angleoutputmax_high, 
			RobotValues.AngleThreshold); //see PID class or hover for definition of all
    
    public GyroTurnCommand() {
    	AnglePID.setSetpoint(0);
    }
    
    public GyroTurnCommand(double angle){
    	AnglePID.setSetpoint(angle);
        System.out.println("Gyro command initialized" + angle);
    }
    
    protected void initialize() {
    	AnglePID.reset();
        AnglePID.setConstants(SmartDashboard.getNumber("AngleKp"),
        		SmartDashboard.getNumber("AngleKi"), SmartDashboard.getNumber("AngleKd"));
    }
    
    public void execute() {
    	AnglePID.calculate(Drive.getAngle());
        System.out.println("output" + AnglePID.getOutput());
    	Drive.setLeftPower(AnglePID.getOutput());
    	Drive.setRightPower(-AnglePID.getOutput());
    }
    protected boolean isFinished() {
        return AnglePID.isDone();
    }
    protected void end() {
        Drive.setPower(0.0);
    }
    protected void interrupted() {
    	end();
    }
}
