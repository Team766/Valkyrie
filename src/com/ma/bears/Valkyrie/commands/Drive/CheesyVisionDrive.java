package com.ma.bears.Valkyrie.commands.Drive;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 *  Drives the robot in the direction of the hands
 * @author Blevenson
 */
public class CheesyVisionDrive extends CommandBase {
    public CheesyVisionDrive() {
        System.out.println("I driving with Cheesy vision!");
    }
    protected void initialize() {
    	Drive.setPower(0.0);
    	Drive.setShifter(false);
    }
    protected void execute() {
        if(!OI.server.getLeftStatus()){
        	Drive.setLeftPower(-0.5);;
        }
        if (!OI.server.getRightStatus()){
        	Drive.setRightPower(0.5);
        }
        if (OI.server.getLeftStatus() && OI.server.getRightStatus()){
        	Drive.setPower(0.0);
        }
        
        System.out.println("Looping through Cheesy Vision Auton");
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        Drive.setPower(0.0);
    }
    protected void interrupted() {
    	end();
    }
}
