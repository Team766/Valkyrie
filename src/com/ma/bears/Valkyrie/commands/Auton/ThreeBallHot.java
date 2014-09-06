package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;

/**
 * This is the three ball HOT auton command.  Unlike the Kevin, team 766 has a working three
 * ball HOT auton, not just one.  Not so cheesy anymore are you Kevin.  Watch out we comming for you.
 * Too bad we cant turn.  :(
 * 
 * @author Blevenson
 */
public class ThreeBallHot extends CommandGroup {
    
	
	/**
	 * Drives to shoot position (near line), shoots, (like One Ball Stay auton)
	 * then goes back, picks up ball, then drives across line and shoots (like 
	 * OneBallMove)
	 * @param shot1distance Distance to move for first shot.
	 * @param pickuptime Time the arm is down
	 * @param drivedistance Distance driven to second shot
	 * @param waitforshoot Time waited between finishing driving and shooting
	 * @param driveDistanceBack3 The distance backwards it drives to collect the ball
	 * @param driveForwardDistance3 The distance forward it drives to the firing location
	 */
    public ThreeBallHot(double shot1distance, double pickuptime, double drivedistance, double waitforshoot, 
    					double driveDistanceBack3, double driveForwardDistance3) {
    	addSequential(new WaitforHotGoalCommand());
    	//Fire Ball one
        addSequential(new DriveForwardCommand(shot1distance));
        addSequential(new ShootCommand());
        addSequential(new WaitCommand(0.05));
        //Fire Ball two
        addParallel(new DriveForwardCommand(-shot1distance));
        addSequential(new PickupCommand(pickuptime));
        addSequential(new DriveForwardCommand(-drivedistance));
        addSequential(new WaitCommand(waitforshoot));
        addSequential(new ShootCommand());
        addSequential(new WaitCommand(0.05));
        //Fire Ball three
        addParallel(new DriveForwardCommand(-driveDistanceBack3));
        addSequential(new PickupCommand(pickuptime));
        addSequential(new DriveForwardCommand(driveForwardDistance3));
        addSequential(new WaitCommand(waitforshoot));
        addSequential(new ShootCommand());
    }
}
