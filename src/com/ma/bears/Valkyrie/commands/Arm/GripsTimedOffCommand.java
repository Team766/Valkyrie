package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Turns grips off after a given time.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class GripsTimedOffCommand extends CommandBase{
	
	private double timeOut = 0.0d;
	public GripsTimedOffCommand(){
		//default constructor that justs turns off the grippers
		timeOut = 0.0d;
	}
	
	public GripsTimedOffCommand(double time){
		//turns grips off after given time
		timeOut = time;
	}	

	protected void end() {
		//turns the grips on after use
		Pickup.setGrippers(true);
	}

	protected void execute() {
		//turns the grips off
		Pickup.setGrippers(false);
	}
	
	protected void initialize() {
		setTimeout(timeOut);
	}

	protected void interrupted() {
		//if canceled end the class and set the grips on
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return isTimedOut();
	}

}
