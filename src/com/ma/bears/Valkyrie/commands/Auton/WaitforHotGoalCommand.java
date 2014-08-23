package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Wait for both CheesyVision blocks to be true.
 * This is used for hot goal.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class WaitforHotGoalCommand extends CommandBase{

	protected void execute() {
	}
	protected void initialize() {
	}
	protected boolean isFinished() {
		return (OI.server.getLeftStatus() && OI.server.getRightStatus());
	}
	protected void interrupted() {
		end();
	}
	protected void end() {
	}
}
