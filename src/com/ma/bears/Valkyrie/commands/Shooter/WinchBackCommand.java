package com.ma.bears.Valkyrie.commands.Shooter;


//import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Winches back shooter until 
 * limit is hit or cancel button
 * on OI is hit.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
*/

public class WinchBackCommand extends Command{
	
	public WinchBackCommand(){
		requires(Valkyrie.Shooter);
	}

	protected void end() {
		Valkyrie.Shooter.setWinch(0);
	}

	protected void execute() {
		Valkyrie.Shooter.setWinchPist(false);
		Valkyrie.Shooter.setWinch(RobotValues.WinchSpeed);
	}

	protected void initialize() {
		
	}

	protected void interrupted() {
		
	}

	protected boolean isFinished() {
		return Valkyrie.Shooter.getShooterDown() || Valkyrie.buttonCancel.get();
		//  Not inverting the limit switch here because it is already done when the
		//  getShooterDown function is initialize
	}

}
