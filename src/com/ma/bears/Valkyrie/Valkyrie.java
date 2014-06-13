/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.CommandBase;
import com.ma.bears.Valkyrie.commands.Auton.AutonSelector;
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
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson blevenson68@gmail.com
 */
public class Valkyrie extends IterativeRobot {
    
    CheesyVisionServer server = CheesyVisionServer.getInstance();
    public final int listenPort = 1180;
    
    public Valkyrie(){
    }
    
    public void robotInit(){
    	//just testing out some SmartDash, DriverLCD stuff
    	SmartDashboard.putString("test", "test");
        SmartDashboard.putBoolean("Cheesy Drive", true);
    	SmartDashboard.putString("test", "testing");
    	//DriverStationLCD lcd = DriverStationLCD.getInstance();
    	//lcd.println(DriverStationLCD.Line.kUser2, 1, "test");
        server.setPort(listenPort);
        server.start();
        System.out.println("robot booted");
        CommandBase.init();
    }
    
    public void disabledInit() {
        server.stopSamplingCounts();
    }
    public void disabledPeriodic(){
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
    }
    
    public void autonomous() {
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
    }
    
    public void teleopPeriodic(){
    	
    	//Command stuff here:
		//commented out on merge because of restructuring
    	/*if(SmartDashboard.getBoolean("Cheesy Drive")){
            new CheesyDriveCommand().start(); //from Team 254
        }
        else if(SmartDashboard.getBoolean("Cheesy Drive")){
            Drive.setRightSpeed(-jRight.getY());
            Drive.setLeftSpeed(jLeft.getY());
        } */
        Scheduler.getInstance().run(); //update commands

        Watchdog.getInstance().feed(); //very hungry
    }
}
