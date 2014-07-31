package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;

/**
 * This is the two ball auton command.  Unlike the Kevin, team 766 has a working two
 * ball auton, not just one.
 * 
 * @author Blevenson
 */
public class TwoBall extends CommandGroup {
    
	
	/**
	 * Drives to shoot position (near line), shoots, (like One Ball Stay auton)
	 * then goes back, picks up ball, then drives across line and shoots (like 
	 * OneBallMove)
	 * @param shot1distance Distance to move for first shot. The robot moves the opposite of this 
	 * distance after shooting to go back to pickup.
	 * @param pickuptime Time the arm is down
	 * @param drivedistance Distance driven to second shot
	 * @param waitforshoot Time waited between finishing driving and shooting
	 */
    public TwoBall(double shot1distance, double pickuptime, double drivedistance, double waitforshoot) {
        addSequential(new WinchBackCommand());
        addSequential(new DriveForwardCommand(shot1distance));
        addSequential(new ShootCommand());
        addSequential(new WaitCommand(0.05));
        addParallel(new DriveForwardCommand(-shot1distance));
        addSequential(new PickupCommand(pickuptime));
        addSequential(new DriveForwardCommand(-drivedistance));
        addSequential(new WaitCommand(waitforshoot));
        addSequential(new ShootCommand());
    }
}
