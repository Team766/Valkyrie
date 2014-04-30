package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * turns grips off
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class GripsOffCommand extends Command{

	@Override
	protected void end() {
		Valkyrie.BallGuard.set(true);
	}

	@Override
	protected void execute() {
		Valkyrie.BallGuard.set(false);
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
