package com.ma.bears.Valkyrie.commands.Shooter;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * Subcommand of the shoot command. 
 * This part releases the winch
 * and waits.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
 */

public class ReleaseShooterCommand extends CommandBase{
	Timer t = new Timer();
        
	protected void initialize() {
		t.reset();
		t.start();
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
		return t.get() > RobotValues.ShooterWait;
	}

}
