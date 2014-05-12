package com.ma.bears.Valkyrie.commands.Arm;


import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns grips on/off.
 * 
 * @author Brett Levenson
 */

public class GripsCommand extends Command{
	private boolean whileRunning;
	private boolean afterRun;
	public GripsCommand(boolean during, boolean after){
		whileRunning = during;
		afterRun = after;
	}	
	protected void end() {
		Valkyrie.Pickup.setArmDown(afterRun);
	}

	protected void execute() {
		Valkyrie.Pickup.setGrippers(whileRunning);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
