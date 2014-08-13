package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.AutonSelector;
import com.ma.bears.Valkyrie.commands.Auton.OneBall;
import com.ma.bears.Valkyrie.commands.Auton.TwoBall;
import com.ma.bears.Valkyrie.commands.Arm.GripsCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.CheesyVisionDrive;
import com.ma.bears.Valkyrie.commands.Drive.DriveForwardCommand;
import com.ma.bears.Valkyrie.commands.Drive.TankDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.TestGyroDrive;

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
 * <p>TODO:
 * <p>Testing with robot on floor.
 * <p>Test new auton selector, and cheesy vision.
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
    	System.out.println("Java Code 2014 V: 1.0.3");
        SmartDashboard.putBoolean("Tank Drive", false);
        SmartDashboard.putBoolean("UseGamePad", false);
        SmartDashboard.putNumber("GyroP",RobotValues.AngleKp);
        SmartDashboard.putNumber("GyroI", RobotValues.AngleKi);
        SmartDashboard.putNumber("GyroD", RobotValues.AngleKd);
        CommandBase.init();
        CommandBase.OI.server.setPort(listenPort);
        CommandBase.OI.server.start();
    }
    
    public void disabledInit() {
        CommandBase.OI.server.stopSamplingCounts();
    }
    
    /** Update Autonomous display
	 * 
	 * <p>Why all the spaces?
	 * You need to flush the display
	 * or else it will display
	 * old text.
     * 
     * <p>We need to try lcd.clear();
	 */
    public void disabledPeriodic(){
    	Scheduler.getInstance().run();

    	
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
            case RobotValues.Auton_GyroDriveTurn:{
            mode = "Auton Gyro Drive Turn";
            line3 = "	Stand Back!      ";
            line4 = "	Not Tested		 ";
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
        CommandBase.Drive.resetGyro();
        //new AutonSelector(CommandBase.OI.AutonMode).start();
        switch(CommandBase.OI.AutonMode){
        	//runs the OneBallStay Command
            case RobotValues.Auton_OneBallStay:{
                System.out.println("One Ball Stay Auton");
                new OneBall(RobotValues.OneBallStay_shootDistance,
                            RobotValues.OneBallStay_crossDistance).start();
                break;
            }
            //runs the TwoBall Command
            case RobotValues.Auton_TwoBall:{
                System.out.println("Two Ball Auton");
                new TwoBall(RobotValues.TwoBall_Shot1Distance, 
                            RobotValues.TwoBall_PickupTime, 
                            RobotValues.TwoBall_Shot2Distance, 
                            RobotValues.TwoBall_WaitforShoot).start();
                break;
            }
            //runs the Move Command
            case RobotValues.Auton_Move:{
                System.out.println("Drive Forward Auton");
                new DriveForwardCommand(RobotValues.OneBallStay_crossDistance).start();
                break;
            }
            //runs the OneBallMove Command
            case RobotValues.Auton_OneBallMove:{
                System.out.println("One Ball Move Auton");
                new OneBall(RobotValues.OneBallMove_Distance).start();
                break;
            }
            //runs the CheesyVision Command
            case RobotValues.Auton_CheesyVision:{
                System.out.println("Cheesy Drive Auton");
                //addSequential(new CheesyVisionDrive());
                new CheesyVisionDrive().start();;
                break;
            }
            //runs the Gyro Drive Turn Command
            case RobotValues.Auton_GyroDriveTurn:{
                System.out.println("Gyro Drive and Turn auton");
                new TestGyroDrive(2d, 45d, 2d).start();
                break;
            }
            default:{
                System.out.println("Auton selection failed");
                break;
            }
			
        }
    }
    
    public void autonomousPeriodic() {
        /*System.out.println("Current left: " + CommandBase.OI.server.getLeftStatus() + ", current right: " + CommandBase.OI.server.getRightStatus());
        System.out.println("Left count: " + CommandBase.OI.server.getLeftCount() + ", right count: " + CommandBase.OI.server.getRightCount());
        System.out.println("Total: " + CommandBase.OI.server.getTotalCount());
    	if(CommandBase.OI.server.getLeftCount() > 5){
    		System.out.println("Left Hand Auton");
    	}
    	else if(CommandBase.OI.server.getRightCount() > 5){
    		System.out.println("Right Hand Auton");
    	}*/
        Scheduler.getInstance().run(); //update commands
    }
    
    public void teleopInit(){
    	CommandBase.OI.setTankDrive(SmartDashboard.getBoolean("Tank Drive"));
    	CommandBase.OI.setUseGamepad(SmartDashboard.getBoolean("UseGamePad"));
		if(!CommandBase.OI.getTankDrive()){
			new CheesyDriveCommand().start();			
		}else{
			new TankDriveCommand().start();
		}
		//set grippers out on enable
		CommandBase.Pickup.setGrippers(true);
    }
    
    public void teleopPeriodic(){
        Scheduler.getInstance().run(); //update commands
        SmartDashboard.putNumber("Speed", CommandBase.Drive.getSpeed());
        Watchdog.getInstance().feed(); //very hungry
    }
}
