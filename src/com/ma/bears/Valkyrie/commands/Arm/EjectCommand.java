package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Arm.GripsCommand;

/**
 * ejector piston out, roller out, and grips off
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class EjectCommand extends CommandGroup{
	
	public EjectCommand(){
		addParallel(new RollerOutCommand());
		addParallel(new EjectorOutCommand());
		addParallel(new GripsCommand(false, false));
	}
}
