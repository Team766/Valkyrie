package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Arm.GripsCommand;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Ejector piston out, roller out, and grips off
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class EjectCommand extends CommandGroup{
	
	public EjectCommand(){
		//Run the rollers backwards
		addParallel(new RollerOutCommand());
		//turn on ejector piston
		addParallel(new EjectorOutCommand());
		//turn grips off while running, but when end, turn back on
		addParallel(new GripsCommand(false, true));
	}
}
