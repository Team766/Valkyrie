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
	
	Timer t = new Timer();

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		t.reset();
		t.start();
		Valkyrie.WinchPist.set(false);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Valkyrie.WinchPist.set(true);		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return t.get() > RobotValues.ShooterWait;
	}

}