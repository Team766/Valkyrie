package com.ma.bears.Valkyrie.commands.Arm;


import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns grips on.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class GripsOnCommand extends Command{

	protected void end() {
		Valkyrie.Pickup.setGrippers(false);
	}

	protected void execute() {
		Valkyrie.Pickup.setGrippers(true);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
