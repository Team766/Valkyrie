package com.ma.bears.Valkyrie.commands.Shooter;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Subcommand of the shoot command. 
 * This part releases the winch
 * and waits.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
 */

public class ReleaseShooterCommand extends CommandBase{
	
	protected void initialize() {
		setTimeout(RobotValues.ShooterWait);
	}

	protected void end() {
		Shooter.setWinchPist(false);
		Pickup.setGrippers(true);
	}

	protected void execute() {
		Pickup.setGrippers(false);
		Shooter.setWinchPist(true);
	}
	
	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

}
