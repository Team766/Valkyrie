package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Arm down, grips off, roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class PickupCommand extends CommandGroup{

	public PickupCommand(){
		addParallel(new RollerInCommand());
		addParallel(new ArmDownCommand());
		addParallel(new GripsOffCommand());
	}
}
