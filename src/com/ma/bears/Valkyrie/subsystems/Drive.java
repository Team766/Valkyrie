/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.OI;
import com.ma.bears.Valkyrie.Ports;
import com.ma.bears.Valkyrie.commands.Drive.CheesyDriveCommand;
import com.ma.bears.Valkyrie.commands.Drive.TankDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drive subsystem.
 * Includes all parts of the robot used to drive.
 * 
 * @author Brett Levenson
 *
 */

public class Drive extends Subsystem{
	
	final private Talon leftDrive = new Talon(Ports.PWM_Left_Drive);
	final private Talon rightDrive = new Talon(Ports.PWM_Right_Drive);
        
	private Encoder LDriveEnc = new Encoder(Ports.DIO_LDriveEncA, Ports.DIO_LDriveEncB);
	private Encoder RDriveEnc = new Encoder(Ports.DIO_RDriveEncA, Ports.DIO_RDriveEncB);
    
    private final Solenoid Shifter = new Solenoid(Ports.Sol_Shifter);
    
	protected void initDefaultCommand() {
	}
	
	public void drive(double speed){
		setLeftSpeed(speed);
		setRightSpeed(speed);
	}
	public void setLeftSpeed(double speed){
		leftDrive.set(-speed);
	}
	public void setRightSpeed(double speed){
		rightDrive.set(speed);
	}
	public void setShifter(boolean highGear){
		Shifter.set(!highGear);
	}
	
    public float translateDrive(float trans){
		double wheel_d = 0.0899;
		double counts = 256 * 4.0;
		return (float) ((trans / counts) * (Math.PI) * wheel_d);
	}
    public float getLeftDistance() {
		return translateDrive(LDriveEnc.getRaw());
	}
	public float getRightDistance() {
		return translateDrive(RDriveEnc.getRaw());
	}
	public void resetEncoders(){
		LDriveEnc.reset();
		RDriveEnc.reset();
	}

}
