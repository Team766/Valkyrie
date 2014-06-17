package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Turns grips on/off.
 * 
 * @author Brett Levenson
 */

public class GripsCommand extends CommandBase{
	private boolean whileRunning;
	private boolean afterRun;
	public GripsCommand(boolean during, boolean after){
		whileRunning = during;
		afterRun = after;
	}
	protected void end() {
		Pickup.setGrippers(afterRun);
	}

	protected void execute() {
		Pickup.setGrippers(whileRunning);
	}

	protected void initialize() {}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return false;
	}

}
