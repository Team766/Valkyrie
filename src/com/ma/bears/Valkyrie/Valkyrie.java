package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Arm.GripsTimedOffCommand;
import com.ma.bears.Valkyrie.commands.Auton.AutonSelector;
import com.ma.bears.Valkyrie.commands.Auton.UpdateAutonSwitch;
import com.ma.bears.Valkyrie.commands.Drive.CheesyDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.TankDriveCommand;
import com.ma.bears.Valkyrie.CheesyVisionServer;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStationLCD;

/**
 * Java code for 2014 robot. Mainly a test
 * and proof of concept to see how well Java
 * works for programming the robot.
 * 
 * Currently drives with a CheesyDrive system.
 * 
 * TODO:
 * Testing with robot on floor.
 * Test new auton slector, and cheesy vision.
 * Remove timings from commands and replace them with built in timeouts.
 *
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 */
public class Valkyrie extends IterativeRobot {
    
    public CheesyVisionServer server = CheesyVisionServer.getInstance();
    public final int listenPort = 1180;
    
	private DriverStationLCD lcd = DriverStationLCD.getInstance();
    
    public Valkyrie(){
    }
    
    public void robotInit(){
    	System.out.println("2014");
    	//just testing out some SmartDash, DriverLCD stuff
    	SmartDashboard.putString("test", "test");
    	SmartDashboard.putString("test", "testing");
        SmartDashboard.putBoolean("Tank Drive", false);
        SmartDashboard.putBoolean("UseGamePad", false);
        server.setPort(listenPort);
        server.start();
        CommandBase.init();
    }
    
    public void disabledInit() {
        server.stopSamplingCounts();
    }
    public void disabledPeriodic(){
    	/* Update Autonomous display
    	 * 
    	 * Why all the spaces?
    	 * You need to flush the display
    	 * or else it will display
    	 * old text.
    	 */
    	 
        //Uncomment when using the Auton Switch thats on the OI
        //new UpdateAutonSwitch().start();        
                
        String mode = "";
    	switch (OI.AutonMode){
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
    		break;
        	}
            case RobotValues.Auton_OneBallMove:{
    		mode = "One Ball, Move Foward";
    		break;
            }
            case RobotValues.Auton_OneBallStay:{
    		mode = "One Ball, Stay       ";
    		break;
            }
            case RobotValues.Auton_TwoBall:{
    		mode = "Two Ball             ";
    		break;
            }
            case RobotValues.Auton_CheesyVision:{
                mode = "Cheesy Vision Drive  ";
                break;
            }
            default: mode = "";
    	}

    	lcd.println(DriverStationLCD.Line.kUser1, 1, "Selected Auton Mode: ");
    	lcd.println(DriverStationLCD.Line.kUser2, 1, mode);
        lcd.println(DriverStationLCD.Line.kUser3, 1, "Good Luck with the Game!");
    	lcd.updateLCD();
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomousInit() {
        server.reset();
        server.startSamplingCounts();
        new AutonSelector().start();
    }
    
    public void autonomousPeriodic() {
        System.out.println("Current left: " + server.getLeftStatus() + ", current right: " + server.getRightStatus());
        System.out.println("Left count: " + server.getLeftCount() + ", right count: " + server.getRightCount() + ", total: " + server.getTotalCount() + "\n");
    	if(server.getLeftCount() > 5){
    		System.out.println("Left Hand Auton");
    	}
    	else if(server.getRightCount() > 5){
    		System.out.println("Right Hand Auton");
    	}
        //Cheesy Vision stuff used in auton
        if(server.getLeftStatus()){
            OI.CheesyVisionLeft = 1;
        }
        else{
            OI.CheesyVisionLeft = 0;
        }
        if(server.getRightStatus()){
            OI.CheesyVisionRight = 1;
        }
        else{
            OI.CheesyVisionRight = 0;
        }
    }
    
    public void teleopInit(){
    	OI.setTankDrive(SmartDashboard.getBoolean("Tank Drive"));
    	OI.setUseGamepad(SmartDashboard.getBoolean("UseGamePad"));
		if(!OI.getTankDrive()){
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
