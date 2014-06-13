package com.ma.bears.Valkyrie.commands;

import com.ma.bears.Valkyrie.subsystems.Drive;
import com.ma.bears.Valkyrie.subsystems.Pickup;
import com.ma.bears.Valkyrie.subsystems.Shooter; 
import com.ma.bears.Valkyrie.OI;
import com.ma.bears.Valkyrie.Ports;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command{
    
    public static Pickup Pickup = new Pickup();
    //public static Compressor Compressor = new Compressor();
    public static Drive Drive = new Drive();
    public static Shooter Shooter = new Shooter(); 
    public static OI OI = new OI();

    //public static Compressor Compr = new Compressor(Ports.DIO_Pressure, Ports.Relay_Compr);
    
    public static void init(){
    	//Compr.start();    	
    }

}
