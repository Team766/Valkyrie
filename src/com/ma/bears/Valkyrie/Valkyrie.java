package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.AutonSelector;
import com.ma.bears.Valkyrie.commands.Drive.CheesyDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.TankDriveCommand;
import com.ma.bears.lib.CSVInput;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStationLCD;
//
/**
 * Java code for 2014 robot. Mainly a test
 * and proof of concept to see how well Java
 * works for programming the robot.
 * 
 * Currently drives with either a CheesyDrive system or
 * tank drive. Selectable in SmartDash.
 * 
 * A DirectInput Gamepad can also be used to control the robot.
 * It needs to be in joystick slot 4. 
 * 
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 */
public class Valkyrie extends IterativeRobot {
    
    public final int listenPort = 1180;
    boolean AutonCyclePrev;
    boolean previousLog = false;
    
    private DriverStationLCD lcd = DriverStationLCD.getInstance();
    private CSVInput CSVInput;
    boolean done;
    
    public Valkyrie(){
    	done = false;
    	//RobotValues.initRobotValues();
    	CSVInput = new CSVInput("file:///RobotValues.csv");
    }
    
    public void robotInit(){
    	System.out.println("Java Code 2014 V: 1.0.4");
    	CommandBase.myLog.print("Java Code 2014 V: 1.0.4");
        SmartDashboard.putBoolean("Tank Drive", false);
        SmartDashboard.putBoolean("UseGamePad", false);
        SmartDashboard.putNumber("AngleKp",RobotValues.AngleKp);
        SmartDashboard.putNumber("AngleKi", RobotValues.AngleKi);
        SmartDashboard.putNumber("AngleKd", RobotValues.AngleKd);
        SmartDashboard.putNumber("P",RobotValues.Kp);
        SmartDashboard.putNumber("D", RobotValues.Kd);
        SmartDashboard.putNumber("TargetAngle", 10);
        CommandBase.init();
        CommandBase.OI.server.setPort(listenPort);
        CommandBase.OI.server.start();
        CommandBase.Drive.startEncoders();
    	CSVInput.readValues();
    	RobotValues.writeFromCSV(CSVInput.getInts(), CSVInput.getDoubles(), 
    			CSVInput.getStrings());
    }
    
    public void disabledInit() {
        CommandBase.OI.server.stopSamplingCounts();
    	CSVInput.readValues();
    	RobotValues.writeFromCSV(CSVInput.getInts(), CSVInput.getDoubles(), 
    			CSVInput.getStrings());
        //Close log
    	if(done)CommandBase.myLog.closeFile();
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
            case RobotValues.Auton_Disabled:
            	mode = "Disabled             ";
            	break;
            case RobotValues.Auton_Empty:
            	mode = "None Selected        ";
            	break;
            case RobotValues.Auton_Move:
            	mode = "Move Forward         ";
            	line3 = "Distance: " + RobotValues.Move_Distance;
            	break;
            case RobotValues.Auton_OneBallMove:
            	mode = "One Ball, Move Foward";
            	line3 = "Distance: " + RobotValues.OneBallMove_Distance;
            	break;
            case RobotValues.Auton_OneBallStay:
            	mode = "One Ball, Stay       ";
            	line3 = "Shoot Distance: " + RobotValues.OneBallStay_shootDistance;
            	line4 = "Cross Distance: " + RobotValues.OneBallStay_crossDistance;
            	break;
            case RobotValues.Auton_TwoBall:
            	mode = "Two Ball             ";
            	line3 = "Shot1 Distance: " + RobotValues.TwoBall_Shot1Distance;
            	line4 = "Shot2 Distance: " + RobotValues.TwoBall_Shot2Distance;
            	break;
            case RobotValues.Auton_CheesyVision:
            	mode = "Cheesy Vision Drive  ";
                line3 = "Tank Drive           ";
            	break;
            case RobotValues.Auton_GyroDriveTurn:
            	mode = "Auton Gyro Drive Turn";
            	line3 = "	Stand Back!      ";
            	line4 = "	Not Tested		 ";
            	break;
            case RobotValues.Auton_HotOneBallMove:
	    		mode = "Hot One Ball, Move   ";
	    		line3 = "Distance: " + RobotValues.OneBallMove_Distance;
	    		break;
            case RobotValues.Auton_HotOneBallStay:
	    		mode = "Hot One Ball, Stay   ";
	    		line3 = "Shoot Distance: " + RobotValues.OneBallStay_shootDistance;
	    		line4 = "Move Distance: " + RobotValues.OneBallStay_crossDistance;
	    		break;
            case RobotValues.Auton_THREEBALLHOT:
        		mode = "Three Ball Hot       ";
        		line3 = "#766 is bretter than";
        		line4 = "#254, suck it Kevin ";
        		break;
            case RobotValues.Auton_CheesyForwardVision:
            	mode = "Cheesy Vision Drive  ";
                line3 = "Forward/Backwards Drive";
            	break;
            default:{} //initialized as spaces so nothing needed here
    	}
    	lcd.println(DriverStationLCD.Line.kUser1, 1, "Selected Auton Mode: ");
    	lcd.println(DriverStationLCD.Line.kUser2, 1, mode);
        lcd.println(DriverStationLCD.Line.kUser3, 1, line3);
        lcd.println(DriverStationLCD.Line.kUser4, 1, line4);
    	lcd.updateLCD();
    	
    	//Auton selector
    	
    	if(!AutonCyclePrev && CommandBase.OI.buttonEjector.get())
    		CommandBase.OI.incrementAutonMode(1);
    	else if(!AutonCyclePrev && CommandBase.OI.buttonPickup.get())
    		CommandBase.OI.incrementAutonMode(-1);
    	AutonCyclePrev = (CommandBase.OI.buttonEjector.get() || CommandBase.OI.buttonPickup.get());
    	
    }
    
    public void autonomousInit() {
        CommandBase.myLog.print("Auton Starting:  ");
    	done = true;
        CommandBase.OI.server.reset();
        CommandBase.OI.server.startSamplingCounts();
        CommandBase.Drive.resetGyro();
        new AutonSelector(CommandBase.OI.AutonMode).start();
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
        CommandBase.myLog.print("Teleop Starting  ");
    	done = true;
    	CommandBase.OI.setTankDrive(SmartDashboard.getBoolean("Tank Drive"));
    	CommandBase.OI.setUseGamepad(SmartDashboard.getBoolean("UseGamePad"));
        if(!CommandBase.OI.getTankDrive()){
            new CheesyDriveCommand().start();			
        }else{
            new TankDriveCommand().start();
        }
	//set grippers out on enable
	//CommandBase.Pickup.setGrippers(true);
        //CommandBase.Drive.resetGyro();
        //new GyroTurnCommand(SmartDashboard.getNumber("TargetAngle")).start();
    }
    
    public void teleopPeriodic(){
        Scheduler.getInstance().run(); //update commands
        SmartDashboard.putNumber("Speed", CommandBase.Drive.getSpeed());
        SmartDashboard.putNumber("GyroAngle", CommandBase.Drive.getAngle());
        //System.out.println("Left Speed: " + CommandBase.Drive.getLeftSpeed());
        //System.out.println("Right Speed: " + CommandBase.Drive.getRightSpeed());
        CommandBase.OI.updateGripSwitch();
        Watchdog.getInstance().feed(); //very hungry
    }
}
