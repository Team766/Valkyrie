package com.ma.bears.Valkyrie.commands.Shooter;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;
import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Subcommand of the shoot command. 
 * This part releases the winch
 * and waits.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
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
		Shooter.setWinchPist(true);		
		Pickup.setGrippers(false);
	}
	
	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return t.get() > RobotValues.ShooterWait;
	}

}
