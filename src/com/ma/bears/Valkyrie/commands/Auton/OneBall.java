package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;

/**
 * OneBall autons.
 * Contains both a stay and a move.
 *
 * @author Brett Levenson
 * @author Nicky Ivy nickivyca@gmail.com
 */
public class OneBall extends CommandGroup {
    
	/**
	 * One Ball Move
	 * @param distance distance moved to shoot
	 */
    public OneBall(double distance) {
    	addParallel(new GripsTimedOffCommand(0)); //to switch on the grips at the beginning of auton
    	addSequential(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(distance));
    	addSequential(new ShootCommand());
    }
    
    /**
     * One Ball Stay
     * 
     * @param shootdistance Distance moved to proper shooting position
     * @param crossdistance Distance moved to cross line
     */
    public OneBall(double shootdistance, double crossdistance){
    	addParallel(new GripsTimedOffCommand(0)); //to switch on the grips at the beginning of auton
    	addSequential(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(shootdistance));
    	addSequential(new ShootCommand());
        addSequential(new DriveForwardCommand(crossdistance));    	
    }
}
