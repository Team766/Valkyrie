package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 */

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class RollerInCommand extends Command{
	
	//roller in

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
		return true;
	}

}
