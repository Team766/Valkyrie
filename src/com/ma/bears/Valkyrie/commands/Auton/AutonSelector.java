package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.OI;
import com.ma.bears.Valkyrie.RobotValues;
import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;

/**
 * Choose which auton command to run
 * 
 * @author Brett Levenson blevenson68@gmail.com
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class AutonSelector extends CommandGroup{

	public AutonSelector(){
		addSequential(new UpdateAutonSelector());
		
		switch(OI.AutonMode){
		case RobotValues.Auton_OneBallStay:{
			System.out.println("One Ball Stay Auton");
            addSequential(new OneBallStay(0.0, true));
            break;
		}
		case RobotValues.Auton_TwoBall:{
			System.out.println("Two Ball Auton");
			addSequential(new TwoBall(1.0, 1.2, 2.0));
			break;
		}
		case RobotValues.Auton_Move:{
			System.out.println("Drive Forward Auton");
			addSequential(new DriveForwardCommand(-2.0));
			break;
		}
		case RobotValues.Auton_OneBallMove:{
			System.out.println("One Ball Move Auton");
			addSequential(new OneBallStay(-2.6, false));
			break;
		}
		default:{
			System.out.println("Auton selection failed");
			break;
		}
			
		}
	}
}
