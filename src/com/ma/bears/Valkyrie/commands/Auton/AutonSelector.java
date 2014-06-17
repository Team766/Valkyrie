package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.OI;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyVisionDrive;

/**
 * Choose which auton command to run
 * 
 * @author Brett Levenson blevenson68@gmail.com
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class AutonSelector extends CommandGroup{

    public AutonSelector(){
        //addSequential(new UpdateAutonSelector());
        
        switch(OI.AutonMode){
            case RobotValues.Auton_OneBallStay:{
                System.out.println("One Ball Stay Auton");
                addSequential(new OneBallStay(0.0, true));
                break;
            }
            case RobotValues.Auton_TwoBall:{
                System.out.println("Two Ball Auton");
                addSequential(new TwoBall(RobotValues.TwoBall_PickupTime, 
                                          RobotValues.TwoBall_Distance, 
                                          RobotValues.TwoBall_WaitforShoot));
                break;
            }
            case RobotValues.Auton_Move:{
                System.out.println("Drive Forward Auton");
                addSequential(new DriveForwardCommand(RobotValues.crossDistance));
                break;
            }
            case RobotValues.Auton_OneBallMove:{
                System.out.println("One Ball Move Auton");
                addSequential(new OneBallStay(RobotValues.OneBallMove_Distance, false));
                break;
            }
            case RobotValues.Auton_CheesyVision:{
                System.out.println("Cheesy Drive Auton");
                addSequential(new CheesyVisionDrive());
            }
            default:{
                System.out.println("Auton selection failed");
                break;
            }
			
        }
    }
}
