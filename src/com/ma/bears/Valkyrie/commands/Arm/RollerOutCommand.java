package com.ma.bears.Valkyrie.commands.Arm;

/**
 * Roller out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;
import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Command;

public class RollerOutCommand extends CommandBase{

	protected void end() {
		Pickup.setRollers(0);
	}

	protected void execute() {
		Pickup.setRollers(RobotValues.ArmWheels_Out);
	}

	protected void initialize() {
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		return false;
	}

}
