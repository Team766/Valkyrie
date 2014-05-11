package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Roller in.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class RollerInCommand extends Command{
	
	private double timeout = 0.0;
	private boolean timed = false;
	private Timer t;

	public RollerInCommand(){
	}
	
	public RollerInCommand(double time){
		timeout = time;
		timed = true;
	}	
	
	protected void end() {
		Valkyrie.Pickup.setRollers(0);;
	}

	protected void execute() {
		Valkyrie.Pickup.setRollers(RobotValues.ArmWheels_In);
	}

	protected void initialize() {
		t.reset();
		t.start();
	}

	protected void interrupted() {
	}

	protected boolean isFinished() {
		//if the command is timed and time is satisfied, done
		//if command is not timed it will never be done
		//and is instead terminated by command system
		return (t.get() > timeout) && timed;
	}

}
