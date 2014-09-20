package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyVisionDrive;
import com.ma.bears.Valkyrie.commands.Drive.TestGyroDrive;
import com.ma.bears.Valkyrie.commands.Shooter.WinchBackCommand;

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
    	
        //Winchback
        if(mode > 0)addSequential(new WinchBackCommand());
    	//check which auton mode is selected
        switch(mode){
        	//runs the OneBallStay Command
            case RobotValues.Auton_OneBallStay:
                System.out.println("One Ball Stay Auton");
                addSequential(new OneBall(RobotValues.OneBallStay_shootDistance,
                						  RobotValues.OneBallStay_crossDistance));
                break;
            
            //runs the TwoBall Command
            case RobotValues.Auton_TwoBall:
                System.out.println("Two Ball Auton");
                addSequential(new TwoBall(RobotValues.TwoBall_Shot1Distance, 
                						  RobotValues.TwoBall_PickupTime, 
                                          RobotValues.TwoBall_Shot2Distance, 
                                          RobotValues.TwoBall_WaitforShoot));
                break;
            
            //runs the Move Command
            case RobotValues.Auton_Move:
                System.out.println("Drive Forward Auton");
                addSequential(new DriveForwardCommand(RobotValues.OneBallStay_crossDistance));
                break;
            
            //runs the OneBallMove Command
            case RobotValues.Auton_OneBallMove:
                System.out.println("One Ball Move Auton");
                addSequential(new OneBall(RobotValues.OneBallMove_Distance));
                break;
            
            //runs the CheesyVision Command
            case RobotValues.Auton_CheesyVision:
                System.out.println("Cheesy Drive Auton");
                //addSequential(new CheesyVisionDrive());
                addSequential(new CheesyVisionDrive(false));
                break;
            
            //runs the Gyro Drive Turn Command
            case RobotValues.Auton_GyroDriveTurn:
                System.out.println("Gyro Drive and Turn auton");
                addSequential(new TestGyroDrive(2d, 45d, 2d));
                break;
                
            //runs the OneBallMove Command
            case RobotValues.Auton_HotOneBallMove:
                System.out.println("Hot One Ball Move Auton");
                addSequential(new HotGoalAuton(RobotValues.OneBallMove_Distance));
                break;
                
        	//runs the OneBallStay Command
            case RobotValues.Auton_HotOneBallStay:
                System.out.println("Hot One Ball Stay Auton");
                addSequential(new HotGoalAuton(RobotValues.OneBallStay_shootDistance,
                						  RobotValues.OneBallStay_crossDistance));
                break;
                
            //runs the Three Ball Hot Auton Command
            case RobotValues.Auton_THREEBALLHOT:
                System.out.println("Three Ball Hot Auton");
                addSequential(new ThreeBallHot(RobotValues.TwoBall_Shot1Distance, 
                							   RobotValues.TwoBall_PickupTime, 
                							   0.0d, 
                							   RobotValues.TwoBall_WaitforShoot, 
                							   2.0, 2.0));
                break;
            case RobotValues.Auton_CheesyForwardVision:
                System.out.println("Cheesy Forward Drive Auton");
                addSequential(new CheesyVisionDrive(true));
                break;
            default:{
                System.out.println("Auton selection failed");
                break;
            }
        }
    }
}
