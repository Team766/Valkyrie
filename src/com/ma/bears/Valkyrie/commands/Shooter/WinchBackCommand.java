package com.ma.bears.Valkyrie.commands.Shooter;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class WinchBackCommand extends Command{
	
	//winches back shooter unless cancel pressed or limit is hit

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
