/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.commands.Auton;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;

/**
 * Brett put a description here
 *
 * @author Blevenson
 */
public class OneBallStay extends CommandGroup {
    
    public OneBallStay() {
       addParallel(new WinchBackCommand());
       addParallel(new DriveForwardCommand(0));  //Fix, Add PID Control
//       if(DriveForwardCommand.done){
           addSequential(new ShootCommand());
//       }
    }
}
