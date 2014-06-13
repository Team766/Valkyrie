package com.ma.bears.Valkyrie;

import com.ma.bears.Valkyrie.commands.Arm.ArmDownCommand;
import com.ma.bears.Valkyrie.commands.Arm.EjectCommand;
import com.ma.bears.Valkyrie.commands.Arm.InboundCommand;
import com.ma.bears.Valkyrie.commands.Arm.PickupCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerInCommand;
import com.ma.bears.Valkyrie.commands.Arm.RollerOutCommand;
import com.ma.bears.Valkyrie.commands.Shooter.ShootCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick
    jLeft = new Joystick(1),
    jRight = new Joystick(2),
    jBox = new Joystick(3);
    
    public Button      
    buttonShifter = new JoystickButton(jLeft, Buttons.Shifter),
    buttonQuickTurn = new JoystickButton(jRight, Buttons.QuickTurn),
    buttonReverse = new JoystickButton(jRight, Buttons.Reverse),
    buttonDriverPickup = new JoystickButton(jRight, Buttons.DriverPickup),
    buttonDriverShoot = new JoystickButton(jRight, Buttons.DriverShoot),
    buttonShoot = new JoystickButton(jBox, Buttons.Shoot),
    buttonWinchOn = new JoystickButton(jBox, Buttons.WinchOn),
    buttonRollerIn = new JoystickButton(jBox, Buttons.RollerIn),
    buttonRollerOut = new JoystickButton(jBox, Buttons.RollerOut),
    buttonPickup = new JoystickButton(jBox, Buttons.Pickup),
    buttonInbound = new JoystickButton(jBox, Buttons.Inbound),
    buttonEjector = new JoystickButton(jBox, Buttons.Ejector),
    buttonArmDown = new JoystickButton(jBox, Buttons.Arm),
    buttonCancel = new JoystickButton(jBox, Buttons.ShootCancel),
    buttonAutonSwitch = new JoystickButton(jBox, Buttons.AutonSwitch);
    
    public static int AutonMode = 0;
	public OI(){
		ShootCommand shoot = new ShootCommand();
    	buttonShoot.whenPressed(shoot);
        buttonCancel.cancelWhenPressed(shoot);  //not really sure how this works?

        buttonRollerIn.whileHeld(new RollerInCommand());
        buttonRollerOut.whileHeld(new RollerOutCommand());
        buttonArmDown.whileHeld(new ArmDownCommand());
        buttonEjector.whileHeld(new EjectCommand());
        
        buttonPickup.whileHeld(new PickupCommand());
        buttonDriverPickup.toggleWhenPressed(new PickupCommand());   //driver is toggle while human is held
        buttonInbound.whileHeld(new InboundCommand());
	}
}
