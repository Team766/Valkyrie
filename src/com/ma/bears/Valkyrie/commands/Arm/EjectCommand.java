package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * ejector piston out, roller out, and grips off
 */

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EjectCommand extends CommandGroup{
	
	public EjectCommand(){
		addParallel(new RollerOutCommand());
		addParallel(new EjectorOutCommand());
		addParallel(new GripsOffCommand());
	}
}
