package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.commands.Arm.GripsOffCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootCommand extends CommandGroup {

	//releases grips and shoots
	//waits
	//winches back
	
	public ShootCommand(){
		addParallel(new GripsOffCommand());
		addSequential(new ReleaseWinchCommand());
		addSequential(new WinchBackCommand());
	}
}
