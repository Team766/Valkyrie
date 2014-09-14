package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Roller out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class RollerOutCommand extends CommandBase{

	protected void end() {
		//turn off rollers
		Pickup.setRollers(0);
	}

	protected void execute() {
		//runs rollers out
		Pickup.setRollers(RobotValues.getDouble("ArmWheels_Out"));
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
