package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * Releases grips and shoots, waits,
 * wniches back.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;

public class ShootCommand extends CommandGroup {

	//releases grips and shoots
	//waits
	//winches back
	
	public ShootCommand(){
		addSequential(new ReleaseShooterCommand());
		addSequential(new WaitCommand(0.75));
		addSequential(new WinchBackCommand());
	}
}
