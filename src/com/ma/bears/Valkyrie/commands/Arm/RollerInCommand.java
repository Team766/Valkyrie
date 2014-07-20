package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class RollerInCommand extends CommandBase{
	//default values for the timer stuff
	private double timeOut = 0.0d;

	public RollerInCommand(){
		timeOut = 0.0d;
	}
	
	public RollerInCommand(double time){
		//runs roller in for set time
		timeOut = time;
	}	
	
	protected void end() {
		//stops rollers after running
		Pickup.setRollers(0);
	}

	protected void execute() {
		//sets rollers to roll in
		Pickup.setRollers(RobotValues.ArmWheels_In);
	}

	protected void initialize() {
		//reset the timer
		setTimeout(timeOut);
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return isTimedOut();
	}

}
