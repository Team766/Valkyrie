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
    
    private Gyro gyro = new Gyro(Ports.Analog_Gyro);
    
	protected void initDefaultCommand() {
	}
	/**
	 * Set power to both motors, 
	 * useful for shutting them off
	 * @param speed power value
	 */
	public void setPower(double speed){
		setLeftPower(speed);
		setRightPower(speed);
	}
	public void setLeftPower(double power){
		leftDrive.set(-power);
	}
	public void setRightPower(double power){
		rightDrive.set(power);
	}
	public void setShifter(boolean highGear){
		Shifter.set(!highGear);
	}
	
	/**
	 * Translates encoder counts for use in 
	 * calculating distance.
	 * @param trans
	 * @return
	 */
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
	public double getLeftSpeed(){
		return LDriveEnc.getRate();
	}
	public double getRightSpeed(){
		return RDriveEnc.getRate();
	}
	public double getSpeed(){
		return (RDriveEnc.getRate() + LDriveEnc.getRate()) / 2;
	}
	public void resetEncoders(){
		LDriveEnc.reset();
		RDriveEnc.reset();
	}
        public void startEncoders(){
		LDriveEnc.start();
		RDriveEnc.start();
	}
	
	//Gyro stuff
	public double getAngle(){
		return gyro.getAngle();
	}
	public void resetGyro(){
		gyro.reset();
	}

}
