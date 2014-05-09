package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.RobotValues;

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class RollerInCommand extends Command{

	protected void end() {
		Valkyrie.ArmWheels.set(0);
	}

	protected void execute() {
		Valkyrie.ArmWheels.set(RobotValues.ArmWheels_In);
	}

	protected void initialize() {
	}

	protected void interrupted() {
	}

	protected boolean isFinished() {
		return false;
	}

}
