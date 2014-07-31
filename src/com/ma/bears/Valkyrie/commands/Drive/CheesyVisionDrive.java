package com.ma.bears.Valkyrie.commands.Drive;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 *  Drives the robot in the direction of the hands
 * @author Blevenson
 */
public class CheesyVisionDrive extends CommandBase {
    public CheesyVisionDrive() {
        System.out.println("I driving with Cheesy vision!");
    }
    protected void initialize() {
    	Drive.drive(0.0);
    }
    protected void execute() {
        if(OI.server.getLeftStatus()) Drive.drive(1.0);
        else if (OI.server.getRightStatus()) Drive.drive(-1.0);
        else Drive.drive(0.0);
        
        System.out.println("Looping through Cheesy Vision Auton");
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        Drive.drive(0.0);
    }
    protected void interrupted() {}
}
