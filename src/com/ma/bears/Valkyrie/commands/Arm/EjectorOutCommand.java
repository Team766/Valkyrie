package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * put ejector piston out
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class EjectorOutCommand extends Command{
	
	@Override
	protected void end() {
		Valkyrie.Ejector.set(false);
	}

	@Override
	protected void execute() {
		Valkyrie.Ejector.set(true);
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
