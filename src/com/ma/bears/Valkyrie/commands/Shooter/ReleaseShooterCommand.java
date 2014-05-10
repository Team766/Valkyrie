package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseShooterCommand extends Command{
	
	//releases winch piston for RobotValues.ShooterWait seconds (default is .75)
	//also releases grippers
    //Wait
	//in other commands:
    //Rewinch
	Timer t = new Timer();
        
	protected void initialize() {
		// TODO Auto-generated method stub
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
