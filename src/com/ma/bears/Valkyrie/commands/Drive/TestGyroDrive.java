package com.ma.bears.Valkyrie.commands.Drive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Test the gyro turn class
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class TestGyroDrive extends CommandGroup{
	public TestGyroDrive(double firstdist, double angle, double seconddist){
		addSequential(new DriveForwardCommand(firstdist));
		addSequential(new GyroTurnCommand(angle));
		addSequential(new DriveForwardCommand(seconddist));
	}
}
