package com.ma.bears.Valkyrie.commands.Shooter;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;


/**
 * Winches back shooter until 
 * limit is hit or cancel button
 * on OI is hit.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
*/

public class WinchBackCommand extends CommandBase{
	
	public WinchBackCommand(){
		requires(Shooter);
	}

	protected void end() {
		Shooter.setWinch(0);
	}

	protected void execute() {
		Shooter.setWinchPist(false);
		Shooter.setWinch(RobotValues.WinchSpeed);
	}

	protected void initialize() {
		
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return Shooter.getShooterDown();
	}

}
