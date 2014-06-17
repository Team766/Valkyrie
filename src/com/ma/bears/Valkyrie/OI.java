package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.Arm.ArmDownCommand;
import com.ma.bears.Valkyrie.commands.Arm.EjectCommand;
import com.ma.bears.Valkyrie.commands.Arm.InboundCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerInCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerOutCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;
import com.ma.bears.Valkyrie.commands.Auton.UpdateAutonSelector;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick
    jLeft = new Joystick(1),
    jRight = new Joystick(2),
    jBox = new Joystick(3),
    jGpad = new Joystick(4);
    
    public Button      
    buttonShifter = new JoystickButton(jLeft, Buttons.Shifter),
    buttonQuickTurn = new JoystickButton(jRight, Buttons.QuickTurn),
    buttonReverse = new JoystickButton(jRight, Buttons.Reverse),
    buttonDriverPickup = new JoystickButton(jRight, Buttons.DriverPickup),
    buttonDriverShoot = new JoystickButton(jRight, Buttons.DriverShoot),
    buttonShoot = new JoystickButton(jBox, Buttons.Shoot),
    buttonRollerIn = new JoystickButton(jBox, Buttons.RollerIn),
    buttonRollerOut = new JoystickButton(jBox, Buttons.RollerOut),
    buttonPickup = new JoystickButton(jBox, Buttons.Pickup),
    buttonInbound = new JoystickButton(jBox, Buttons.Inbound),
    buttonEjector = new JoystickButton(jBox, Buttons.Ejector),
    buttonArmDown = new JoystickButton(jBox, Buttons.Arm),
    buttonCancel = new JoystickButton(jBox, Buttons.ShootCancel),
    buttonAutonSwitch = new JoystickButton(jBox, Buttons.AutonSwitch),
    
    //gamepad buttons
    GPbuttonShifter = new JoystickButton(jGpad, Buttons.GPShifter),
    GPbuttonQuickTurn = new JoystickButton(jGpad, Buttons.GPQuickTurn),
    GPbuttonReverse = new JoystickButton(jGpad, Buttons.GPReverse),
    GPbuttonShoot = new JoystickButton(jGpad, Buttons.GPShoot),
    GPbuttonRollerIn = new JoystickButton(jGpad, Buttons.GPRollerIn),
    GPbuttonRollerOut = new JoystickButton(jGpad, Buttons.GPRollerOut),
    GPbuttonPickup = new JoystickButton(jGpad, Buttons.GPPickup),
    GPbuttonInbound = new JoystickButton(jGpad, Buttons.GPInbound),
    GPbuttonEjector = new JoystickButton(jGpad, Buttons.GPEjector),
    GPbuttonArmDown = new JoystickButton(jGpad, Buttons.GPArm),
    GPbuttonCancel = new JoystickButton(jGpad, Buttons.GPShootCancel);
    
    
    //Auton Stuff
    public static int AutonMode = 0;
    public static int CheesyVisionLeft = 0;
    public static int CheesyVisionRight = 0;
    
    public static boolean TankDrive = false;
    public static boolean UseGamepad = false;
    
	public OI(){
		ShootCommand shoot = new ShootCommand();
                UpdateAutonSelector selector = new UpdateAutonSelector();
    	buttonShoot.whenPressed(shoot);
        buttonCancel.cancelWhenPressed(shoot);
        
        buttonAutonSwitch.whenPressed(selector);

        buttonRollerIn.whileHeld(new RollerInCommand());
        buttonRollerOut.whileHeld(new RollerOutCommand());
        buttonArmDown.whileHeld(new ArmDownCommand());
        buttonEjector.whileHeld(new EjectCommand());
        
        buttonPickup.whileHeld(new PickupCommand());
        buttonDriverPickup.toggleWhenPressed(new PickupCommand());   //driver is toggle while human is held
        buttonInbound.whileHeld(new InboundCommand());
        
        //gamepad buttons
    	GPbuttonShoot.whenPressed(shoot);
        GPbuttonCancel.cancelWhenPressed(shoot);

        GPbuttonRollerIn.whileHeld(new RollerInCommand());
        GPbuttonRollerOut.whileHeld(new RollerOutCommand());
        GPbuttonArmDown.whileHeld(new ArmDownCommand());
        GPbuttonEjector.whileHeld(new EjectCommand());
        
        GPbuttonPickup.whileHeld(new PickupCommand());
        GPbuttonInbound.whileHeld(new InboundCommand());
	}
	
	//interface for possible gamepad support
	
	public boolean getShifter(){
		return !UseGamepad? buttonShifter.get() : GPbuttonShifter.get();
	}
	public boolean getQuickTurn(){
		return !UseGamepad? buttonQuickTurn.get() : GPbuttonQuickTurn.get();
	}
	public boolean getReverse(){
		return !UseGamepad? buttonReverse.get() : GPbuttonReverse.get();
	}
	
	//cheesydrive here
	public double getThrottle(){
		return !UseGamepad? jLeft.getY() : jGpad.getRawAxis(2);
	}
	public double getSteer(){
		return !UseGamepad? jRight.getX() : jGpad.getRawAxis(3);
	}
	//tank drive here
	public double getLeft(){
		return !UseGamepad? jLeft.getRawAxis(2) : jGpad.getRawAxis(2);
	}
	public double getRight(){
		return !UseGamepad? jRight.getRawAxis(2) : jGpad.getRawAxis(4);
	}
	public static void setTankDrive(boolean in){
		TankDrive = in;
	}
	public static boolean getTankDrive(){
		return TankDrive;
	}
	public static void setUseGamepad(boolean in){
		UseGamepad = in;
	}
	public static boolean getUseGamepad(){
		return UseGamepad;
	}
}
