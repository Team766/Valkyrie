/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.ma.bears.Valkyrie;

/**
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 * Java code for 2014 robot. Mainly a test
 * and proof of concept to see how well Java
 * works for programming the robot.
 * 
 * Currently drives with a tank system.
 * CheesyDrive may be implemented later.
 * 
 * Command-based things are commented out
 * for now. This means the shooter is
 * manually pulled back by a button.
 * 
 * TODO:
 * Cheesy Drive
 */
import com.ma.bears.Valkyrie.commands.Arm.ArmDownCommand;
import com.ma.bears.Valkyrie.commands.Arm.EjectCommand;
import com.ma.bears.Valkyrie.commands.Arm.InboundCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerInCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerOutCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;

import com.ma.bears.Valkyrie.CheesyVisionServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.DriverStationLCD;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Valkyrie extends IterativeRobot {
    
    CheesyVisionServer server = CheesyVisionServer.getInstance();
    public final int listenPort = 1180;
    
    public static Joystick jLeft = new Joystick(1);
    public static Joystick jRight = new Joystick(2);
    public static Joystick jBox = new Joystick(3);
    
    public static final Talon leftDrive = new Talon(Ports.PWM_Left_Drive);
    public static final Talon rightDrive = new Talon(Ports.PWM_Right_Drive);
    public static final Jaguar Winch = new Jaguar(Ports.PWM_Winch);
    public static final Talon ArmWheels = new Talon(Ports.PWM_ArmWheels);
    
    public static final Relay Compr = new Relay(Ports.Relay_Compr);
    
    public static final DigitalInput Pressure = new DigitalInput(Ports.DIO_Pressure);
    public static final DigitalInput LauncherBotm = new DigitalInput(Ports.DIO_LauncherBotm);
    
    public static final Solenoid 
    Shifter = new Solenoid(Ports.Sol_Shifter),
    WinchPist = new Solenoid(Ports.Sol_WinchPist),
    Arm = new Solenoid(Ports.Sol_Arm),
    BallGuard = new Solenoid(Ports.Sol_BallGuard),
    Ejector = new Solenoid(Ports.Sol_Ejector);
    
    
    //declare joystick buttons as Buttons instead of reading them raw
    //not always used yet - useful for running things with commands
    public static final Button  
    //button name = new JoystickButton(joystick, button number),        
    buttonShifter = new JoystickButton(jLeft, Buttons.Shifter),
    buttonReverse = new JoystickButton(jRight, Buttons.Reverse),
    buttonDriverPickup = new JoystickButton(jRight, Buttons.DriverPickup),
    buttonDriverShoot = new JoystickButton(jRight, Buttons.DriverShoot),
    buttonShoot = new JoystickButton(jBox, Buttons.Shoot),
    buttonWinchOn = new JoystickButton(jBox, Buttons.WinchOn),
    buttonRollerIn = new JoystickButton(jBox, Buttons.RollerIn),
    buttonRollerOut = new JoystickButton(jBox, Buttons.RollerOut),
    buttonPickup = new JoystickButton(jBox, Buttons.Pickup),
    buttonInbound = new JoystickButton(jBox, Buttons.Inbound),
    buttonEjector = new JoystickButton(jBox, Buttons.Ejector),
    buttonArmDown = new JoystickButton(jBox, Buttons.Arm),
    		
    buttonAutoShoot = new JoystickButton(jBox, Buttons.AutoShoot),
    buttonCancel = new JoystickButton(jBox, Buttons.ShootCancel);
    
    public void robotInit(){
    	//just testing out some SmartDash, DriverLCD stuff
    	SmartDashboard.putString("test", "test");
    	DriverStationLCD lcd = DriverStationLCD.getInstance();
    	lcd.println(DriverStationLCD.Line.kUser1, 1, "test");
        server.setPort(listenPort);
        server.start();
    }
    public void autonomousInit() {
        server.reset();
        server.startSamplingCounts();
    }
    
    public void disabledInit() {
        server.stopSamplingCounts();
    }
    
    public void autonomousPeriodic() {
        System.out.println("Current left: " + server.getLeftStatus() + ", current right: " + server.getRightStatus());
        System.out.println("Left count: " + server.getLeftCount() + ", right count: " + server.getRightCount() + ", total: " + server.getTotalCount() + "\n");
    }
    
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        while(isAutonomous() && isEnabled()){
            if(server.getLeftCount() > 5){
                System.out.println("Left Hand Auton");
            }
            else if(server.getRightCount() > 5){
                System.out.println("Right Hand Auton");
            }   
            //Goalie Pole Stuff
            /*if(server.getLeftStatus()){
                //Move Backwards
            } 
            if(server.getRightStatus()){
                //Move Forwards
            }
            */
        }
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
    }
    
    public void teleopPeriodic(){
        
        //Tank drive input
        double LeftDriveC = -jLeft.getRawAxis(2);
        double RightDriveC = jRight.getRawAxis(2);
        
        boolean ShifterC = (jLeft.getRawButton(Buttons.Shifter));
        boolean ReverseC = (jLeft.getRawButton(Buttons.Reverse)); 
        
        //switches robot to drive like shooter is front, as opposed to pickup
        if(ReverseC){
        	double RightSave = RightDriveC;
            RightDriveC = LeftDriveC;
            LeftDriveC = RightSave;
        }
        leftDrive.set(LeftDriveC);
        rightDrive.set(RightDriveC);
        Shifter.set(!ShifterC);
			
        //Winch
        //Press button to pull down winch on shooter
        //Press separate button to launch
        boolean ShooterWinchOnC = jBox.getRawButton(Buttons.WinchOn);
        boolean ShooterLaunchC = (jBox.getRawButton(Buttons.Shoot) || jRight.getRawButton(Buttons.DriverShoot));
        
        boolean ShooterLoaded = !LauncherBotm.get();
        
        double WinchC = (!ShooterLoaded && !ShooterLaunchC && ShooterWinchOnC)? RobotValues.WinchSpeed : 0;
        
        WinchPist.set(ShooterLaunchC);
        Winch.set(WinchC);
	    
        //ball grippers default to on, but by code
        //this way on, off works properly by commands with true, false
        //but we want them default on to hold ball more reliably
        boolean BallGuardC = true;
        if (jBox.getRawAxis(4) < 0 && !ShooterLaunchC){
        	BallGuardC = false;
        }
        
        
        boolean EjectorC = jBox.getRawButton(Buttons.Ejector);
        boolean ArmC = jBox.getRawButton(Buttons.Arm);
        boolean PickupC = (jBox.getRawButton(Buttons.Pickup) || jRight.getRawButton(Buttons.DriverPickup));
        boolean InboundC = jBox.getRawButton(Buttons.Inbound);
        boolean RollerInC = jBox.getRawButton(Buttons.RollerIn);
        boolean RollerOutC = jBox.getRawButton(Buttons.RollerOut);

        double ArmWheelsC = 0;
		if(RollerInC){     //manual roller in
			ArmWheelsC = RobotValues.ArmWheels_In;
		}
		if(RollerOutC){    //manual roller out
			ArmWheelsC = RobotValues.ArmWheels_Out;
		}
        if(PickupC){       //combo pickup - arm down, roller in, grips on
            ArmWheelsC = RobotValues.ArmWheels_In;
            BallGuardC = true;
            ArmC = true;
        }
        if(InboundC){      //combo inbound - arm down, roller out, grips off
            ArmWheelsC = RobotValues.ArmWheels_Out;
            BallGuardC = false;
            ArmC = true;
        }
        if(EjectorC){      //eject - ejector piston on, roller out, grips off
            ArmWheelsC = RobotValues.ArmWheels_Out;
            BallGuardC = false;
            //the ejector itself will use EjectorC
        }
        Arm.set(ArmC);
        ArmWheels.set(ArmWheelsC);
        BallGuard.set(BallGuardC);
        Ejector.set(EjectorC);
        
        /*
         * attempts at automatic commands here
         * commented out at the moment for testing later
         * 
        */
/*        buttonShoot.whenPressed(new ShootCommand());
        //buttonCancel.cancelWhenPressed(new ShootSeqCommand());  //not really sure how this works?

        buttonRollerIn.whileHeld(new RollerInCommand());
        buttonRollerOut.whileHeld(new RollerOutCommand());
        buttonArmDown.whileHeld(new ArmDownCommand());
        buttonEjector.whileHeld(new EjectCommand());
        
        buttonPickup.whileHeld(new PickupCommand());
        buttonDriverPickup.toggleWhenPressed(new PickupCommand());   //driver is toggle while human is held
        buttonInbound.whileHeld(new InboundCommand()); */
        
        //compressor
        Compr.set(Pressure.get()? Relay.Value.kOff : Relay.Value.kForward);

        Scheduler.getInstance().run(); //update commands
        Watchdog.getInstance().feed(); //very hungry
    }
}
