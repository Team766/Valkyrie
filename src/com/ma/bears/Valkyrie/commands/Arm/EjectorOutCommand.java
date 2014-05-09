package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.Valkyrie;

/**
 * Put ejector piston out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 */

import edu.wpi.first.wpilibj.command.Command;

public class EjectorOutCommand extends Command{
	
	protected void end() {
		Valkyrie.Ejector.set(false);
	}

	protected void execute() {
		Valkyrie.Ejector.set(true);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
