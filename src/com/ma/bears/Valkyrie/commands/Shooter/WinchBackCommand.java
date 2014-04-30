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

	@Override
	protected void end() {
		Valkyrie.Winch.set(0);
	}

	@Override
	protected void execute() {
		Valkyrie.WinchPist.set(true);
		Valkyrie.Winch.set(RobotValues.WinchSpeed);
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return !Valkyrie.LauncherBotm.get() || Valkyrie.jBox.getRawButton(Buttons.ShootCancel);
	}

}
