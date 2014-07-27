package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyVisionDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Choose which auton command to run
 * This runs after the AutonSelector is updtated.
 * Runs the apropriate auton mode
 * 
 * @author Brett Levenson blevenson68@gmail.com
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class AutonSelector extends CommandGroup{

    public AutonSelector(int mode){
    	//pass in the auton mode
    	
    	//check which auton mode is selected
        switch(mode){
        	//runs the OneBallStay Command
            case RobotValues.Auton_OneBallStay:{
                System.out.println("One Ball Stay Auton");
                addSequential(new OneBall(RobotValues.OneBallStay_shootDistance,
                						  RobotValues.OneBallStay_crossDistance));
                break;
            }
            //runs the TwoBall Command
            case RobotValues.Auton_TwoBall:{
                System.out.println("Two Ball Auton");
                addSequential(new TwoBall(RobotValues.TwoBall_Shot1Distance, 
                						  RobotValues.TwoBall_PickupTime, 
                                          RobotValues.TwoBall_Shot2Distance, 
                                          RobotValues.TwoBall_WaitforShoot));
                break;
            }
            //runs the Move Command
            case RobotValues.Auton_Move:{
                System.out.println("Drive Forward Auton");
                addSequential(new DriveForwardCommand(RobotValues.OneBallStay_crossDistance));
                break;
            }
            //runs the OneBallMove Command
            case RobotValues.Auton_OneBallMove:{
                System.out.println("One Ball Move Auton");
                addSequential(new OneBall(RobotValues.OneBallMove_Distance));
                break;
            }
            //runs the CheesyVision Command
            case RobotValues.Auton_CheesyVision:{
                System.out.println("Cheesy Drive Auton");
                addSequential(new CheesyVisionDrive());
            }
            //runs the Gyro Drive Turn Command
            case RobotValues.Auton_GyroDriveTurn:{
                System.out.println("Gyro Drive and Turn auton");
                addSequential(new TestGyroDrive(2d, 45d, 2d));
            }
            default:{
                System.out.println("Auton selection failed");
                break;
            }
			
        }
    }
}
