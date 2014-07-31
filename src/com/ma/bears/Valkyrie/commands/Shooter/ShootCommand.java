package com.ma.bears.Valkyrie.commands.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Releases grips and shoots, waits,
 * winches back.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class ShootCommand extends CommandGroup {
	
	public ShootCommand(){
		addSequential(new ReleaseShooterCommand());
		addSequential(new WinchBackCommand());
	}
}
