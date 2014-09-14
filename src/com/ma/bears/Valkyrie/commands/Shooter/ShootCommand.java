package com.ma.bears.Valkyrie.commands.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Auton.WaitCommand;
import com.ma.bears.Valkyrie.RobotValues;

/**
 * Releases grips and shoots, waits,
 * winches back.
 * 
 * <p>The shoot command uses a delay of .1 seconds
 * to allow for the grip pistons to retract.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class ShootCommand extends CommandGroup {
	
	public ShootCommand(){
		addParallel(new GripsTimedOffCommand(RobotValues.getDouble("ShooterGripWait")
				+ RobotValues.getDouble("ShooterWait")));
		addSequential(new WaitCommand(.10));
		addSequential(new ReleaseShooterCommand());
		addSequential(new WinchBackCommand());
	}
}
