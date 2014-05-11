package com.ma.bears.Valkyrie.commands.Arm;

/**
 * Roller out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class RollerOutCommand extends Command{

	protected void end() {
		Valkyrie.Pickup.setRollers(0);
	}

	protected void execute() {
		Valkyrie.Pickup.setRollers(RobotValues.ArmWheels_Out);
	}

	protected void initialize() {
	}

	protected void interrupted() {
	}

	protected boolean isFinished() {
		return false;
	}

}
