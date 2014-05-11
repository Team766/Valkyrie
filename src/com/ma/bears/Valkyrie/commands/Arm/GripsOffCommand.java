package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns grips off.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 */

public class GripsOffCommand extends Command{

	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t;
	
	public GripsOffCommand(){
	}
	
	public GripsOffCommand(double time){
		timeout = time;
		timed = true;
	}	

	protected void end() {
		Valkyrie.BallGuard.set(true);
	}

	protected void execute() {
		Valkyrie.BallGuard.set(false);
	}
	
	protected void initialize() {
		t.reset();
		t.start();
	}

	protected void interrupted() {}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return (t.get() > timeout) && timed;
	}

}
