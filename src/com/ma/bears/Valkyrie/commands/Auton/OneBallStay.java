/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.RobotValues;

/**
 * Brett put a description here
 *
 * @author Blevenson
 */
public class OneBallStay extends CommandGroup {
    
    public OneBallStay(double distance, boolean cross) {
    	addParallel(new GripsTimedOffCommand(0.01)); //to switch on the grips at the beginning of auton
    	addSequential(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(distance));
    	addSequential(new ShootCommand());
        if (cross){
            addSequential(new DriveForwardCommand(RobotValues.crossDistance));
        }
    }
}
