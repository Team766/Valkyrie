package com.ma.bears.Valkyrie.commands.Shooter;


import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;


/**
 * Winches back shooter until 
 * limit is hit or cancel button
 * on OI is hit.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
*/

public class WinchBackCommand extends Command{

	protected void end() {
		Valkyrie.Winch.set(0);
	}

	protected void execute() {
		Valkyrie.WinchPist.set(true);
		Valkyrie.Winch.set(RobotValues.WinchSpeed);
		
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !Valkyrie.LauncherBotm.get() || Valkyrie.jBox.getRawButton(Buttons.ShootCancel);
	}

}
