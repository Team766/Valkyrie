package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * Puts arm down.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class ArmDownCommand extends CommandBase{
	
	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t;
	
	public ArmDownCommand(){
		t = new Timer();
	}
	
	public ArmDownCommand(double time){
		timeout = time;
		timed = true;
	}	

	protected void end() {
		Pickup.setArmDown(false);
	}
	
	protected void execute() {
		Pickup.setArmDown(true);
	}

	protected void initialize() {
		t.reset();
		t.start();
	}

	protected void interrupted() {
		end();
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return (t.get() > timeout) && timed;
	}

}
