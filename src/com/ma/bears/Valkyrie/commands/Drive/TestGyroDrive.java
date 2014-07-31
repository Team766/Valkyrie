package com.ma.bears.Valkyrie.commands.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This is the gyro drive straight and turn, then drive forward
 * more auton.  This is a test of the gyro, acts like the poofs
 * awesome auton at einstine with the truning auton.  Needs to be
 * test.  The valuse are made up.  Watch out when running.
 * 
 * @author Blevenson
 */
public class TestGyroDrive extends CommandGroup {
    
    public TestGyroDrive(double distanceForward, double turnAngle, double driveForward2) {
    	addSequential(new DriveForwardCommand(distanceForward));
    	addSequential(new GyroDriveCommand(turnAngle));
    	addSequential(new DriveForwardCommand(driveForward2));
    }
}
