package com.ma.bears.Valkyrie.commands.Drive;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Tank drive,
 * with ability to reverse robot.
 * If reverse is held then the rear of
 * the robot feels like the front to the driver.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class TankDriveCommand extends CommandBase{
	protected void end() {
		Drive.setLeftSpeed(0);
		Drive.setRightSpeed(0);
		Drive.setShifter(false);
	}
	protected void execute() {
		double leftC = OI.getLeft();
		double rightC = OI.getRight();
		boolean reverseC = OI.getReverse();
		if(reverseC){
			double RightSave = rightC;
			rightC = leftC;
			leftC = RightSave;
		}
		Drive.setLeftSpeed(leftC);
		Drive.setRightSpeed(rightC);
		Drive.setShifter(OI.getShifter());
	}
	protected void initialize() {
	}
	protected void interrupted() {
	}
	protected boolean isFinished() {
		return false;
	}

}
