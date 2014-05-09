package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Puts arm down.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class ArmDownCommand extends Command{

	protected void end() {
		Valkyrie.Arm.set(false);
	}
	
	protected void execute() {
		Valkyrie.Arm.set(true);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
