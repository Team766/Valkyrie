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
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;

/**
 *
 * @author Blevenson
 */
public class TwoBall extends CommandGroup {
    
    public TwoBall(double pickuptime, double drivedistance, double waitforshoot) {
        addSequential(new WinchBackCommand());
        addSequential(new ShootCommand());
        addSequential(new WaitCommand(0.05));
        addSequential(new PickupCommand(pickuptime));
        addSequential(new DriveForwardCommand(-drivedistance));
        addSequential(new WaitCommand(waitforshoot));
        addSequential(new ShootCommand());
        
    }
}
