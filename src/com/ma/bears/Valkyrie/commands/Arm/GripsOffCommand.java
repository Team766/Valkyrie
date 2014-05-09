package com.ma.bears.Valkyrie.commands.Arm;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * turns grips off
 */

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.Command;

public class GripsOffCommand extends Command{

	protected void end() {
		Valkyrie.BallGuard.set(true);
	}

	protected void execute() {
		Valkyrie.BallGuard.set(false);
	}
	
	protected void initialize() {}

	protected void interrupted() {}

	protected boolean isFinished() {
		return true;
	}

}
