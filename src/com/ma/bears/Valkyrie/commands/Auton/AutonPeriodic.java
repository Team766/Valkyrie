/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Auton;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 * Cleans up the Autonomous Periodic function in Valkyrie.java
 * @author Blevenson
 */
public class AutonPeriodic extends CommandBase {
    
    public AutonPeriodic() {}
    protected void initialize() {}
    protected void execute() {
        System.out.println("Current left: " + OI.server.getLeftStatus() + ", current right: " + OI.server.getRightStatus());
        System.out.println("Left count: " + OI.server.getLeftCount() + ", right count: " + OI.server.getRightCount() + ", total: " + OI.server.getTotalCount() + "\n");
    	if(OI.server.getLeftCount() > 5){
    		System.out.println("Left Hand Auton");
    	}
    	else if(OI.server.getRightCount() > 5){
    		System.out.println("Right Hand Auton");
    	}
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {}
    protected void interrupted() {}
}
