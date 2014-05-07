package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class GripsOnCommand extends Command{
	
	//turns grips on

	protected void end() {
		Valkyrie.BallGuard.set(false);
	}

	protected void execute() {
		Valkyrie.BallGuard.set(true);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
