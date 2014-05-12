package com.ma.bears.Valkyrie.commands.Arm;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Arm down, rollers out, grips off.
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class InboundCommand extends CommandGroup{
	
	public InboundCommand(){
		addParallel(new RollerOutCommand());
		addParallel(new ArmDownCommand());
		addParallel(new GripsCommand(false, true));
	}
}
