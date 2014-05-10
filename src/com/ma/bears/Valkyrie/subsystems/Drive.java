/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.Ports;
import com.ma.bears.Valkyrie.RobotValues;
import edu.wpi.first.wpilibj.Encoder;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

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
        
	public static Encoder LDriveEnc = new Encoder(Ports.DIO_LDriveEncA, Ports.DIO_LDriveEncB);
        public static Encoder RDriveEnc = new Encoder(Ports.DIO_RDriveEncA, Ports.DIO_RDriveEncB);
	
	protected void initDefaultCommand() {
	}
	
	public void Forward(double speed){
		leftDrive.set(-speed);
                rightDrive.set(speed);
	}
        public float translateDrive(float trans){
		double wheel_d = 0.0899;
		double counts = 256 * 4.0;
		//return (trans / counts) * (Math.atan(1) * 4) * wheel_d;
	}
        public float left_distance() {
		return translateDrive(LDriveEnc.getRaw());
	}
	public float right_distance() {
		return translateDrive(RDriveEnc.getRaw());
	}
	
}
