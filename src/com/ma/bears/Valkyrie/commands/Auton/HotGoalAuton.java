package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * HotGoal auton. Same as regular one ball but waits for 
 * hot goal (via CheesyVision driver input)
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class HotGoalAuton extends CommandGroup{
	
	/**
	 * Hot One Ball Move
	 * @param distance distance moved to shoot
	 */
    public HotGoalAuton(double distance) {
    	addParallel(new GripsTimedOffCommand(0)); //to switch on the grips at the beginning of auton
    	addSequential(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(distance));
    	addSequential(new WaitforHotGoalCommand());
    	addSequential(new ShootCommand());
    }
    
    /**
     * Hot One Ball Stay
     * 
     * @param shootdistance Distance moved to proper shooting position
     * @param crossdistance Distance moved to cross line
     */
    public HotGoalAuton(double shootdistance, double crossdistance){
    	addParallel(new GripsTimedOffCommand(0)); //to switch on the grips at the beginning of auton
    	addSequential(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(shootdistance));
    	addSequential(new WaitforHotGoalCommand());
    	addSequential(new ShootCommand());
        addSequential(new DriveForwardCommand(crossdistance));
    }

}
