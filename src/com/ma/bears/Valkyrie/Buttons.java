package com.ma.bears.Valkyrie;

/**
 * Declare button numbers in a convenient place that allows us to change them
 * quickly without sorting through code. 
 * <p>
 * If the buttons are not labeled on the joysticks themselves, a
 * handy way to view them (on Windows) is 'joy.cpl' (enter in the start menu)
 * and then select the joystick. It will show which buttons are which.
 * 
 * <p>Driver joysticks
 * <pre>
 * 1: trigger
 * 2-6: they are labeled
 * 7: the little pinky button//Box joystick
 * </pre>
 * 
 * Box op is able to run on either the OI or the silver KOP joystick.
 * For the box op the buttons are as follows:
 * 
 * <pre>
 * 1: red button labeled shoot
 * 2: switch below the red button
 * 3/5: switch labeled roller
 * 4: white button at left of triangle
 * 6: white button at top of triangle
 * 7: auton on/off switch
 * 11: white button at bottom right of triangle
 * 12: switch labled arm up/down
 * axis 4: the clamp switch - if less than 1 true
 * knob (runs through POV hat)
 *  slot 1: labeled forward
 *  slot 2: labeled 1 ball
 *  slot 3: labeled 2 ball
 *  slot 4: labeled 3 ball
 *  </pre>
 *  
 * For the silver KOP buttons are all labeled with numbers, except trigger is 1 and thumb button is 2.
 * <p>
 * For knob emulation:
 * <pre>
 *  slot 1: hold right
 *  slot 2: hold left
 *  slot 3: hold down
 *  slot 4: hold up </pre>
 *  
 *  For gamepad, mapping is as follows:
 *  <pre>
 *  1: Square/X (not cross)
 *  2: Cross/A
 *  3: Circle/B
 *  4: Triangle/Y
 *  5: Left trigger1
 *  6: Right trigger1
 *  7: Left trigger2
 *  8: Right trigger2
 *  9/10: empty or custom mapped to enable/disable
 *  11: Left stick press
 *  12: Right stick press
 *  </pre>
 */ 
public class Buttons {
    public static int Shifter = 7;
    public static int Reverse = 7;
    public static int QuickTurn = 7;
    public static int DriverPickup = 2;
    public static int DriverShoot = 1;
    
    
    public static int Shoot = 1;
    public static int WinchOn = 2;
    public static int RollerIn = 3;
    public static int RollerOut = 5;
    public static int Pickup = 4;
    public static int Inbound = 6;
    public static int Ejector = 11;
    public static int Arm = 12;
    
    public static int AutoShoot = 8;
    public static int ShootCancel = 2;
    
    public static int AutonSwitch = 7;    
    public static int Axis_Horizontal = 5;
    public static int Axis_Vertical = 6;
    
    //Gamepad buttons
    public static int GPShifter = 11; //
    public static int GPReverse = 12;
    public static int GPQuickTurn = 12;
    public static int GPShoot = 5;
    public static int GPRollerIn = 1;
    public static int GPRollerOut = 2;
    public static int GPPickup = 4;
    public static int GPInbound = 3;
    public static int GPEjector = 8;
    public static int GPArm = 6;
    public static int GPShootCancel = 7;
   
    
}
