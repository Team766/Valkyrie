package com.ma.bears.Valkyrie.commands.Arm;

import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Put ejector piston out.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */

public class EjectorOutCommand extends CommandBase{
	
	public EjectorOutCommand(/*double timeout*/){
		//setTimeout(timeout);
	}
	
	protected void end() {
		//bring piston in after running the class
		Pickup.setEjector(false);
                myLog.print("Ejector Command has eneded");
	}

	protected void execute() {
		//put the ejector piston out
		Pickup.setEjector(true);
	}

	protected void initialize() {}

	protected void interrupted() {
		//if canceled, end the class
		end();
	}

	protected boolean isFinished() {
		//pops the piston out than brings it back in
		return false;
	}

}
