package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.Ports;
import com.ma.bears.Valkyrie.RobotValues;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Arm subsystem.
 * Includes all parts of the robot used to pick up
 * and hold ball.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class Arm extends Subsystem{
	
	private Talon Roller = new Talon(Ports.PWM_ArmWheels);
	
	private Solenoid Arm = new Solenoid(Ports.Sol_Arm);
	private Solenoid Grippers = new Solenoid(Ports.Sol_BallGuard);
	private Solenoid Ejector = new Solenoid(Ports.Sol_Ejector);
	
	protected void initDefaultCommand() {
	}
	
	public void wheelsIn(){
		Roller.set(RobotValues.ArmWheels_In);
	}
	
	public void wheelsOut(){
		Roller.set(RobotValues.ArmWheels_Out);
	}
	
	public void setRollers(double speed){
		Roller.set(speed);
	}
	
	public void setArmDown(boolean down){
		Arm.set(down);
	}
	
	public void setGrippers(boolean on){
		Grippers.set(on);
	}
	
	public void setEjector(boolean on){
		Ejector.set(on);
	}
}
