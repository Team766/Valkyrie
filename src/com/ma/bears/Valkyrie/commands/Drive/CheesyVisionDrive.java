package com.ma.bears.Valkyrie.commands.Drive;
import com.ma.bears.Valkyrie.commands.CommandBase;

/**
 *  Drives the robot in the direction of the hands
 * @author Blevenson
 */
public class CheesyVisionDrive extends CommandBase {
    boolean goal = false;
    public CheesyVisionDrive(){
        this(false);
    }
    public CheesyVisionDrive(boolean goal) {
        this.goal = goal;
        System.out.println("Im driving with Cheesy vision!");
    }
    protected void initialize() {
    	Drive.setPower(0.0);
    	Drive.setShifter(false);
    }
    protected void execute() {
        if(!goal)
        {
            if(!OI.server.getLeftStatus())
            {
                    Drive.setLeftPower(-0.5);
            }
            if (!OI.server.getRightStatus())
            {
                    Drive.setRightPower(-0.5);
            }
        }else if(goal)
        {
            if(!OI.server.getLeftStatus())
            {
                Drive.setPower(-0.5);
            }
            else if(!OI.server.getRightStatus())
            {
                Drive.setPower(0.5);
            }
        }
        if (OI.server.getLeftStatus() && OI.server.getRightStatus()){
            Drive.setPower(0.0);
            
        }
    }
    protected boolean isFinished() {
        return false;
    }
    protected void end() {
        Drive.setPower(0.0);
    }
    protected void interrupted() {
    	end();
    }
}
