package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class RollerInCommand extends Command{
	
	//roller in

	@Override
	protected void end() {
		Valkyrie.ArmWheels.set(0);
	}

	@Override
	protected void execute() {
		Valkyrie.ArmWheels.set(RobotValues.ArmWheels_In);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void interrupted() {
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

}
