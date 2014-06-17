package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

/**
 * Roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class RollerInCommand extends CommandBase{
	
	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t;

	public RollerInCommand(){
		t = new Timer();
		timed = false;
	}
	
	public RollerInCommand(double time){
		timeout = time;
		timed = true;
	}	
	
	protected void end() {
		Pickup.setRollers(0);
	}

	protected void execute() {
		Pickup.setRollers(RobotValues.ArmWheels_In);
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
