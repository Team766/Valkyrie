package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PickupCommand extends CommandGroup{
	
	//arm down, grips off, roller in

	public PickupCommand(){
		addParallel(new RollerInCommand());
		addParallel(new ArmDownCommand());
		addParallel(new GripsOffCommand());
	}
}
