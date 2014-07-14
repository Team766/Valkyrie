package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * Turns grips off after a given time.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class GripsTimedOffCommand extends CommandBase{

	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t = new Timer();
	
	public GripsTimedOffCommand(){
		//default constructor that justs turns off the grippers
		timed = false;
	}
	
	public GripsTimedOffCommand(double time){
		//turns grips off after given time
		timeout = time;
		timed = true;
	}	

	protected void end() {
		//turns the grips on after use
		Pickup.setGrippers(true);
	}

	protected void execute() {
		//tunrs the grips off
		Pickup.setGrippers(false);
	}
	
	protected void initialize() {
		//reset and start the timer for the timed grips off
		t.reset();
		t.start();
	}

	protected void interrupted() {
		//if canceled end the class and set the grips on
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return (t.get() > timeout) && timed;
	}

}
