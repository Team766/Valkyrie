package com.ma.bears.Valkyrie.commands.Arm;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Arm down, rollers out, grips off.
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class InboundCommand extends CommandGroup{
	
	public InboundCommand(){
		//sets the rollers to roll outwards
		addParallel(new RollerOutCommand());
		//puts arm down
		addParallel(new ArmDownCommand());
		//sets the grips off than after running, turns them back on
		addParallel(new GripsCommand(false, true));
	}
}
