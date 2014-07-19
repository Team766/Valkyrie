package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Auton.AutonSelector;
//import com.ma.bears.Valkyrie.commands.Auton.UpdateAutonSwitch;  //commented out
import com.ma.bears.Valkyrie.commands.Drive.CheesyDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.TankDriveCommand;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Java code for 2014 robot. Mainly a test
 * and Poof of concept to see how well Java
 * works for programming the robot.
 * 
 * Currently drives with a CheesyDrive system.
 * 
 * TODO:
 * Testing with robot on floor.
 * Test new auton selector, and cheesy vision.
 * Remove timings from commands and replace them with built in timeouts.
 * Test lcd.clear();
 *
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 */
public class Valkyrie extends IterativeRobot {
    
    public final int listenPort = 1180;
    boolean AutonCyclePrev;
    
	private DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    public Valkyrie(){
    }
    
    public void robotInit(){
    	System.out.println("Java Code 2014 V: 1.0.2");
        SmartDashboard.putBoolean("Tank Drive", false);
        SmartDashboard.putBoolean("UseGamePad", false);
        CommandBase.init();
        CommandBase.OI.server.setPort(listenPort);
        CommandBase.OI.server.start();
    }
    
    public void disabledInit() {
        CommandBase.OI.server.stopSamplingCounts();
    }
    public void disabledPeriodic(){
    	Scheduler.getInstance().run();
    	/* Update Autonomous display
    	 * 
    	 * Why all the spaces?
    	 * You need to flush the display
    	 * or else it will display
    	 * old text.
         * 
         * We Need to try lcd.clear();
    	 */
    	 
        //Uncomment when using the Auton Switch thats on the OI
        //new UpdateAutonSwitch().start();
    	
        String mode = "                           ";
        String line3 = "                           ";
        String line4 = "                           ";
    	lcd.println(DriverStationLCD.Line.kUser2, 1, mode);
        lcd.println(DriverStationLCD.Line.kUser3, 1, line3);
        lcd.println(DriverStationLCD.Line.kUser4, 1, line4);
        lcd.updateLCD(); //during teleop updating twice might lag but we're disabled
    	switch (CommandBase.OI.AutonMode){
            case RobotValues.Auton_Disabled:{
    		mode = "Disabled             ";
    		break;
            }
            case RobotValues.Auton_Empty:{
    		mode = "None Selected        ";
    		break;
            }
            case RobotValues.Auton_Move:{
    		mode = "Move Forward         ";
    		line3 = "Distance: " + RobotValues.Move_Distance;
    		break;
        	}
            case RobotValues.Auton_OneBallMove:{
    		mode = "One Ball, Move Foward";
    		line3 = "Distance: " + RobotValues.OneBallMove_Distance;
    		break;
            }
            case RobotValues.Auton_OneBallStay:{
    		mode = "One Ball, Stay       ";
    		line3 = "Shoot Distance: " + RobotValues.OneBallStay_shootDistance;
    		line4 = "Move Distance: " + RobotValues.OneBallStay_crossDistance;
    		break;
            }
            case RobotValues.Auton_TwoBall:{
    		mode = "Two Ball             ";
    		line3 = "Shot1 Distance: " + RobotValues.TwoBall_Shot1Distance;
    		line4 = "Shot2 Distance: " + RobotValues.TwoBall_Shot2Distance;
    		break;
            }
            case RobotValues.Auton_CheesyVision:{
            mode = "Cheesy Vision Drive  ";
            break;
            }
            default:{} //initialized as spaces so nothing needed here
    	}

    	lcd.println(DriverStationLCD.Line.kUser1, 1, "Selected Auton Mode: ");
    	lcd.println(DriverStationLCD.Line.kUser2, 1, mode);
        lcd.println(DriverStationLCD.Line.kUser3, 1, line3);
        lcd.println(DriverStationLCD.Line.kUser4, 1, line4);
    	lcd.updateLCD();
    	
    	//Auton selector
    	if(!AutonCyclePrev && (CommandBase.OI.buttonAutonSwitch.get() || CommandBase.OI.GPbuttonAuton.get()))
    		CommandBase.OI.incrementAutonMode();
    	AutonCyclePrev = (CommandBase.OI.buttonAutonSwitch.get() || CommandBase.OI.GPbuttonAuton.get());
    }
    
    public void autonomousInit() {
        CommandBase.OI.server.reset();
        CommandBase.OI.server.startSamplingCounts();
        new AutonSelector(CommandBase.OI.AutonMode).start();
    }
    
    public void autonomousPeriodic() {
        System.out.println("Current left: " + CommandBase.OI.server.getLeftStatus() + ", current right: " + CommandBase.OI.server.getRightStatus());
        System.out.println("Left count: " + CommandBase.OI.server.getLeftCount() + ", right count: " + CommandBase.OI.server.getRightCount());
        System.out.println("Total: " + CommandBase.OI.server.getTotalCount());
    	if(CommandBase.OI.server.getLeftCount() > 5){
    		System.out.println("Left Hand Auton");
    	}
    	else if(CommandBase.OI.server.getRightCount() > 5){
    		System.out.println("Right Hand Auton");
    	}
    }
    
    public void teleopInit(){
    	CommandBase.OI.setTankDrive(SmartDashboard.getBoolean("Tank Drive"));
    	CommandBase.OI.setUseGamepad(SmartDashboard.getBoolean("UseGamePad"));
		if(!CommandBase.OI.getTankDrive()){
			new CheesyDriveCommand().start();			
		}else{
			new TankDriveCommand().start();
		}
		new GripsTimedOffCommand(0).start(); //set grippers out on enable
    }
    
    public void teleopPeriodic(){
        Scheduler.getInstance().run(); //update commands

        Watchdog.getInstance().feed(); //very hungry
    }
}
