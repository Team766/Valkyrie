package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * 	Command that interprets auton mode from the joystick
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 *
 */

public class UpdateAutonSelector extends CommandBase{
	public UpdateAutonSelector(){
		//so it doens't really seem to do anything unless put in constructor
		if(OI.jBox.getRawAxis(Buttons.Axis_Horizontal) < 0){
			AutonSelector.AutonMode = RobotValues.Auton_OneBallStay;
		}
		else if(OI.jBox.getRawAxis(Buttons.Axis_Vertical) > 0){
			AutonSelector.AutonMode = RobotValues.Auton_TwoBall;
		}
		else if(OI.jBox.getRawAxis(Buttons.Axis_Horizontal) > 0){
			AutonSelector.AutonMode = RobotValues.Auton_Move;
		}
		else if(OI.jBox.getRawAxis(Buttons.Axis_Vertical) < 0){
			AutonSelector.AutonMode = RobotValues.Auton_OneBallStay;
		}
	}
	
	protected void end() {}
	protected void execute() {}
	protected void initialize() {}
	protected void interrupted() {
		end();
	}
	protected boolean isFinished() {
		return true;
	}

}
