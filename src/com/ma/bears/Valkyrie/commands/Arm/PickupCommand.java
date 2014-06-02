package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Arm down, grips off, roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
 */

public class PickupCommand extends CommandGroup{

	public PickupCommand(){
		addParallel(new RollerInCommand());
		addParallel(new ArmDownCommand());
		addParallel(new GripsCommand(false, true));  //Grips in
	}
	public PickupCommand(double time){ 
		addParallel(new RollerInCommand(time));
		addParallel(new ArmDownCommand(time));
		addParallel(new GripsTimedOffCommand(time));
	}
}
