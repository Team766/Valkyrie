package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * Releases grips and shoots, waits,
 * winches back.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootCommand extends CommandGroup {

	//releases grips and shoots
	//waits
	//winches back
	
	public ShootCommand(){
		addSequential(new ReleaseShooterCommand());
		addSequential(new WinchBackCommand());
	}
}
