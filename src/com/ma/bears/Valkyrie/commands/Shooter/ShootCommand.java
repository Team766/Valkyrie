package com.ma.bears.Valkyrie.commands.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;
import com.ma.bears.Valkyrie.RobotValues;

/**
 * Releases grips and shoots, waits,
 * winches back.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class ShootCommand extends CommandGroup {
	
	public ShootCommand(){
                //addParallel(new GripsCommand(false, false));
            addParallel(new GripsTimedOffCommand(RobotValues.ShooterGripWait +
                    RobotValues.ShooterWait));
            addSequential(new WaitCommand(.10));
		addSequential(new ReleaseShooterCommand());
		addSequential(new WinchBackCommand());
                //addSequential(new GripsCommand(false, true));
	}
}
