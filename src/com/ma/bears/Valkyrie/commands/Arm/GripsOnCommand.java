package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class GripsOnCommand extends Command{
	
	//turns grips on

	@Override
	protected void end() {
		Valkyrie.BallGuard.set(false);
	}

	@Override
	protected void execute() {
		Valkyrie.BallGuard.set(true);
	}

	@Override
	protected void initialize() {}

	@Override
	protected void interrupted() {}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
