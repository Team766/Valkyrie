package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * ejector piston out, roller out, and grips off
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class EjectCommand extends CommandGroup{
	
	public EjectCommand(){
		addParallel(new RollerOutCommand());
		addParallel(new EjectorOutCommand());
		addParallel(new GripsOffCommand());
	}
}
