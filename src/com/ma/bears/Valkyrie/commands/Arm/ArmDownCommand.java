package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * Puts arm down
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class ArmDownCommand extends Command{

	@Override
	protected void end() {
		Valkyrie.Arm.set(false);
	}

	@Override
	protected void execute() {
		Valkyrie.Arm.set(true);
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
