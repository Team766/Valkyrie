package com.ma.bears.Valkyrie.commands.Arm;


import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns grips on/off.
 * 
 * @author Brett Levenson
 */

public class GripsCommand extends Command{
	private static boolean isOn;
	private static boolean wantOn;
	public GripsCommand(boolean status, boolean turnOn){
		isOn = status;
		wantOn = turnOn;
	}	
	protected void end() {
		if(isOn){
			Valkyrie.Pickup.setGrippers(false);
		}else if(!isOn && wantOn){  //wantOn so they arn't left on all the time
			Valkyrie.Pickup.setGrippers(true);
		}
	}

	protected void execute() {
		if(isOn){
			Valkyrie.Pickup.setGrippers(true);
		}else if(!isOn){
			Valkyrie.Pickup.setGrippers(false);
		}
	}

	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return false;
	}

}
