package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InboundCommand extends CommandGroup{
	
	//arm down, rollers out, grips off
	
	public InboundCommand(){
		addParallel(new RollerOutCommand());
		addParallel(new ArmDownCommand());
		addParallel(new GripsOffCommand());
	}
}
