package com.ma.bears.Valkyrie.commands.Auton;

import com.ma.bears.Valkyrie.Valkyrie;

import edu.wpi.first.wpilibj.command.CommandGroup;
import com.ma.bears.Valkyrie.Buttons;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;

/**
 * Choose which auton command to run
 * 
 * @author Brett Levenson blevenson68@gmail.com
 */

public class AutonSelector extends CommandGroup {

	public void execute() {
		if(Valkyrie.jBox.getRawAxis(Buttons.Axis_Horizontal) < 0){
			//One Ball Stay Auton
			System.out.println("One Ball Stay Auton");
            addSequential(new OneBallStay(0.0, true));
		}
		else if(Valkyrie.jBox.getRawAxis(Buttons.Axis_Vertical) > 0){
			//Two Ball Auton
			System.out.println("Two Ball Auton");
			addSequential(new TwoBall(1.0, 1.2, 2.0));
		}
		else if(Valkyrie.jBox.getRawAxis(Buttons.Axis_Horizontal) > 0){
			//Drive Forward Auton
			System.out.println("Drive Forward Auton");
			addSequential(new DriveForwardCommand(-2.0));
		}
		else if(Valkyrie.jBox.getRawAxis(Buttons.Axis_Vertical) < 0){
			//One Ball Move Auton
			System.out.println("One Ball Move Auton");
			addSequential(new OneBallStay(-2.6, false));
		}
	}
}
