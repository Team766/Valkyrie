/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;
import com.ma.bears.Valkyrie.commands.Arm.GripsCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;

/**
 * Brett put a description here
 *
 * @author Blevenson
 */
public class OneBallStay extends CommandGroup {
    
    public OneBallStay(double distance, boolean cross) {
    	addParallel(new GripsCommand(false, false));
    	addParallel(new WinchBackCommand());
    	addSequential(new DriveForwardCommand(distance));  //Fix, Add PID Control
    	addSequential(new ShootCommand());
        if (cross){
            addSequential(new DriveForwardCommand(-2.0));
        }
    }
}
