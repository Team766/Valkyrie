package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.Ports;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Gyro;

/**
 * Drive subsystem.
 * Includes all parts of the robot uses to drive.
 * 
 * @author Brett Levenson
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class Drive extends Subsystem{
	
	private Talon leftDrive = new Talon(Ports.PWM_Left_Drive);
	private Talon rightDrive = new Talon(Ports.PWM_Right_Drive);
        
	private Encoder LDriveEnc = new Encoder(Ports.DIO_LDriveEncA, Ports.DIO_LDriveEncB);
	private Encoder RDriveEnc = new Encoder(Ports.DIO_RDriveEncA, Ports.DIO_RDriveEncB);
    
    private Solenoid Shifter = new Solenoid(Ports.Sol_Shifter);
    
    private Gyro gyro;
    
	protected void initDefaultCommand() {
		gyro = new Gyro(Ports.PORT_GYRO);
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
	
	//Gyro stuff
	public double getAngle(){
		return gyro.getAngle();
	}
	public void resetGyro(){
		gyro.reset();
	}

}
