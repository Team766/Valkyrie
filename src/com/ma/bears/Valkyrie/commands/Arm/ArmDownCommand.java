package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Puts arm down.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class ArmDownCommand extends CommandBase{
	
	public ArmDownCommand(){
		//Default constructor without a timed run
	}
	
	public ArmDownCommand(double time){
		//used to keep arm down for given time
		setTimeout(time);
	}	

	protected void end() {
		//bring arm up after running
		Pickup.setArmDown(false);
	}
	
	protected void execute() {
		//put arm down
		Pickup.setArmDown(true);
	}

	protected void initialize() {
	}

	protected void interrupted() {
		//if command is canceled, end it
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return isTimedOut();
	}

}
