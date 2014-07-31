package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * 	Command that updates the autonomous mode using the switch on the OI
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 *
 */

public class UpdateAutonSwitch extends CommandBase {
	public UpdateAutonSwitch() {
		// It doens't do anything unless put in constructor,
		// because isFinished is set to true

		if (OI.buttonAutonSwitch.get()) {
			OI.AutonMode = RobotValues.Auton_Empty;
			if (OI.jBox.getRawAxis(Buttons.Axis_Horizontal) < 0) {
				OI.AutonMode = RobotValues.Auton_OneBallStay;
			} else if (OI.jBox.getRawAxis(Buttons.Axis_Vertical) > 0) {
				OI.AutonMode = RobotValues.Auton_TwoBall;
			} else if (OI.jBox.getRawAxis(Buttons.Axis_Horizontal) > 0) {
				OI.AutonMode = RobotValues.Auton_Move;
			} else if (OI.jBox.getRawAxis(Buttons.Axis_Vertical) < 0) {
				OI.AutonMode = RobotValues.Auton_OneBallMove;
			}
		} else {
			OI.AutonMode = RobotValues.Auton_Disabled;
		}
	}
	protected void end() {
	}
	protected void execute() {
	}
	protected void initialize() {
	}
	protected void interrupted() {
		end();
	}
	protected boolean isFinished() {
		return true;
	}
}
