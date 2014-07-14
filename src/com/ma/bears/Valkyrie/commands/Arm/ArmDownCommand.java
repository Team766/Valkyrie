package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * Puts arm down.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class ArmDownCommand extends CommandBase{
	
	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t;
	
	public ArmDownCommand(){
		//Default constructor without a timed run
		t = new Timer();
	}
	
	public ArmDownCommand(double time){
		//used to keep arm down for given time
		timeout = time;
		timed = true;
	}	

	protected void end() {
		//bring arm up after running
		Pickup.setArmDown(false);
	}
	
	protected void execute() {
		//put arm down
		Pickup.setArmDown(true);
	}

	protected void initialize() {
		//start the timer for the arm
		t.reset();
		t.start();
	}

	protected void interrupted() {
		//if command is canceled, end it
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return (t.get() > timeout) && timed;
	}

}
