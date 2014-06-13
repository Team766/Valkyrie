package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.Valkyrie;

/**
 * Put ejector piston out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 */

import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

public class EjectorOutCommand extends CommandBase{
	
	public EjectorOutCommand(){
	}
	
	protected void end() {
		Pickup.setEjector(false);
	}

	protected void execute() {
		Pickup.setEjector(true);
	}

	protected void initialize() {}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return false;
	}

}
