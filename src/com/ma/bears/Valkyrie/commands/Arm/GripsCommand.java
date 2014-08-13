package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Turns grips on/off.  First parameter tells what you want to do now with the
 * grips(On/Off).  Than the second bool that is passed says wether you want to
 * leave the grips on or off after running this class
 * 
 * @author Brett Levenson
 */

public class GripsCommand extends CommandBase{
	final private boolean whileRunning;
	final private boolean afterRun;
	public GripsCommand(boolean during, boolean after){
		whileRunning = during;
		afterRun = after;
	}
	protected void end() {
		//sets the grippers in/out based on the second
		//parameter that was passed in
		Pickup.setGrippers(afterRun);
	}

	protected void execute() {
		//sets the grippers in/out based on the first
		//parameter that was passed in
		Pickup.setGrippers(whileRunning);
	}

	protected void initialize() {}

	protected void interrupted() {
		//if this class is canceled than put the grips to
		//their default state
		end();
	}

	protected boolean isFinished() {
		return false;
	}

}
