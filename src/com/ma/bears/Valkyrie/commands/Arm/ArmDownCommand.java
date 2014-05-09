package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * Puts arm down
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

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
		return true;
	}

}
