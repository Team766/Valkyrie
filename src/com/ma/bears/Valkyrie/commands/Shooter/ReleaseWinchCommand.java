package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ReleaseWinchCommand extends Command{
	
	//releases winch piston for RobotValues.ShooterWait seconds (default is .75)
	//Fire
        //Wait
        //Rewinch
	Timer t = new Timer();
        
	protected void initialize() {
		// TODO Auto-generated method stub
		t.reset();
		t.start();
	}

	protected void end() {
            //After Fire Rewinch
            Valkyrie.WinchPist.set(true);
		
	}

	protected void execute() {
		Valkyrie.WinchPist.set(false);		
	}
	
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return t.get() > RobotValues.ShooterWait;
	}

}
