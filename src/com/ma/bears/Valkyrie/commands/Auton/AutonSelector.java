package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyVisionDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Choose which auton command to run
 * 
 * @author Brett Levenson blevenson68@gmail.com
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class AutonSelector extends CommandGroup{

    public AutonSelector(int mode){
        switch(mode){
            case RobotValues.Auton_OneBallStay:{
                System.out.println("One Ball Stay Auton");
                addSequential(new OneBall(RobotValues.OneBallStay_shootDistance,
                						  RobotValues.OneBallStay_crossDistance));
                break;
            }
            case RobotValues.Auton_TwoBall:{
                System.out.println("Two Ball Auton");
                addSequential(new TwoBall(RobotValues.TwoBall_Shot1Distance, 
                						  RobotValues.TwoBall_PickupTime, 
                                          RobotValues.TwoBall_Shot2Distance, 
                                          RobotValues.TwoBall_WaitforShoot));
                break;
            }
            case RobotValues.Auton_Move:{
                System.out.println("Drive Forward Auton");
                addSequential(new DriveForwardCommand(RobotValues.OneBallStay_crossDistance));
                break;
            }
            case RobotValues.Auton_OneBallMove:{
                System.out.println("One Ball Move Auton");
                addSequential(new OneBall(RobotValues.OneBallMove_Distance));
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
