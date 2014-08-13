package com.ma.bears.Valkyrie.commands.Arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Arm.GripsCommand;

/**
 * Arm down, grips off, roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class PickupCommand extends CommandGroup{

	public PickupCommand(){
		//runs the roller in
		addParallel(new RollerInCommand());
		//puts arm down
		addParallel(new ArmDownCommand());
		//Brings grips in, than after puts them out
		addParallel(new GripsCommand(false, true));
	}
	public PickupCommand(double time){ 
		//Pickup after time
		//Same as above just runs for a set time
		addParallel(new RollerInCommand(time));
		addParallel(new ArmDownCommand(time));
		addParallel(new GripsTimedOffCommand(time));
	}
}
