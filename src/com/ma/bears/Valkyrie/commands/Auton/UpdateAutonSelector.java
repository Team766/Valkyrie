package com.ma.bears.Valkyrie.commands.Auton;

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
	public UpdateAutonSelector(){
            //It doens't do anything unless put in constructor,
            //because isFinished is set to true
            OI.AutonMode++;
                
            if (OI.AutonMode > RobotValues.Auton_Max){
                OI.AutonMode = -1;
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
