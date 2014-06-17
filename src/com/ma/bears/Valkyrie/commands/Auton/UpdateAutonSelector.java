package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * 	Command that adds one and resets the count for the selected auton
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 *
 */

public class UpdateAutonSelector extends CommandBase{
        //boolean done = false; 
	public UpdateAutonSelector(){
		//It doens't do anything unless put in constructor,
		//because isFinished is set to true
            
                OI.AutonMode++;
                
                if (OI.AutonMode > RobotValues.Auton_Max){
                    OI.AutonMode = -1;
                }
                /*
		if (OI.buttonAutonSwitch.get()) {
			OI.AutonMode = RobotValues.Auton_Empty; 
			if (OI.jBox.getRawAxis(Buttons.Axis_Horizontal) < 0) {
				OI.AutonMode = RobotValues.Auton_OneBallStay;
			}else if (OI.jBox.getRawAxis(Buttons.Axis_Vertical) > 0) {
				OI.AutonMode = RobotValues.Auton_TwoBall;
			}else if (OI.jBox.getRawAxis(Buttons.Axis_Horizontal) > 0) {
				OI.AutonMode = RobotValues.Auton_Move;
			}else if (OI.jBox.getRawAxis(Buttons.Axis_Vertical) < 0) {
				OI.AutonMode = RobotValues.Auton_OneBallMove;
			}
		}else{
			OI.AutonMode = RobotValues.Auton_Disabled;
		}
                */
	}
	
	protected void end() {
            //done = false;
        }
	protected void execute() {
           /* 
            if (OI.buttonAutonSwitch.get()) {
                OI.AutonMode++;
                done = true;
            }
            if (OI.AutonMode > RobotValues.Auton_Max){
                OI.AutonMode = -1;
            }
            */
        }
	protected void initialize() {}
	protected void interrupted() {
		end();
	}
	protected boolean isFinished() {
		//return done;
                return true;
	}

}
