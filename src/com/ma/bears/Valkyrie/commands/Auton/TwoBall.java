/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;
import com.ma.bears.Valkyrie.commands.Arm.GripsOnCommand;
import com.ma.bears.Valkyrie.commands.Arm.GripsOffCommand;
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;

/**
 *
 * @author Blevenson
 */
public class TwoBall extends CommandGroup {
    
    public TwoBall() {
        addParallel(new WinchBackCommand());
        addParallel(new GripsOffCommand());
        addSequential(new ShootCommand());
        addSequential(new WaitCommand(0.05));
        addSequential(new PickupCommand());
        addParallel(new GripsOnCommand());
        addSequential(new DriveForwardCommand(-1.2));
        addParallel(new GripsOffCommand());
        addSequential(new WaitCommand(2.0));
        addSequential(new ShootCommand());
    }
}
