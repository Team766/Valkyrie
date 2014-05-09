package com.ma.bears.Valkyrie.subsystems;

import com.ma.bears.Valkyrie.Ports;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Compressor. If pressure is not full,
 * turn on the compressor. If pressure 
 * is full, turn it off.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class Compressor extends Subsystem{
	
	private Relay CRelay = new Relay(Ports.Relay_Compr);
	private DigitalInput Pressure = new DigitalInput(Ports.DIO_Pressure); 
	
	public Compressor(){
		super();
	}
	
	protected void initDefaultCommand() {
	}
	
	public void update(){
        CRelay.set(Pressure.get()? Relay.Value.kOff : Relay.Value.kForward);
	}

}
