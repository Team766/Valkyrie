package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.Ports;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Contains the winch motors,
 * winch piston, and 
 * hall effect sensor.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class Shooter extends Subsystem{
	
	private Jaguar Winch = new Jaguar(Ports.PWM_Winch);
	
	private Solenoid WinchPist = new Solenoid(Ports.Sol_WinchPist);
	
	private DigitalInput LauncherBotm = new DigitalInput(Ports.DIO_LauncherBotm);

	public Shooter(){
	}
	protected void initDefaultCommand() {
	}
	
	public void setWinch(double speed){
		Winch.set(speed);
	}
	
	public void setWinchPist(boolean on){
		WinchPist.set(on);
	}
	
	public boolean getShooterDown(){
		return !LauncherBotm.get();
	}
	

}
