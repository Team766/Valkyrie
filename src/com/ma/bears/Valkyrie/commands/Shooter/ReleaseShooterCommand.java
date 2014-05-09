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
 */

public class ReleaseShooterCommand extends Command{
	Timer t = new Timer();
        
	protected void initialize() {
		t.reset();
		t.start();
	}

	protected void end() {
            //After Fire Rewinch
            Valkyrie.WinchPist.set(false);
            Valkyrie.BallGuard.set(true);
	}

	protected void execute() {
		Valkyrie.WinchPist.set(true);		
		Valkyrie.BallGuard.set(false);
	}
	
	protected void interrupted() {
		
	}

	protected boolean isFinished() {
		return t.get() > RobotValues.ShooterWait;
	}

}
