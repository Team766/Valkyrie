package com.ma.bears.Valkyrie.commands.Shooter;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Subcommand of the shoot command. 
 * This part releases the winch
 * and waits.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
 */

public class ReleaseShooterCommand extends Command{
	Timer t = new Timer();
        
	protected void initialize() {
		t.reset();
		t.start();
	}

	protected void end() {
		Valkyrie.Shooter.setWinchPist(false);
		Valkyrie.Pickup.setGrippers(true);
	}

	protected void execute() {
		Valkyrie.Pickup.setGrippers(false);
		Valkyrie.Shooter.setWinchPist(true);		
	}
	
	protected void interrupted() {
		
	}

	protected boolean isFinished() {
		return t.get() > RobotValues.ShooterWait;
	}

}
