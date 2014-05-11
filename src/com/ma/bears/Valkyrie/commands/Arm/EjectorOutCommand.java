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
	
	public EjectorOutCommand(){
	}
	
	protected void end() {
		Valkyrie.Pickup.setEjector(false);
	}

	protected void execute() {
		Valkyrie.Pickup.setEjector(true);
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
