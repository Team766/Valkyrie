/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ma.bears.Valkyrie;

/**
 * Declare port numbers in a convenient place that allows us to change them
 * quickly without sorting through code.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * 
 */
public class Ports {
    public static final int PWM_Left_Drive = 9;
    public static final int PWM_Right_Drive = 2;
    public static final int PWM_Winch = 8;
    public static final int PWM_ArmWheels = 5;
    public static final int PWM_Rollers = 5;
    
    public static final int Relay_Compr = 1;
    
    public static final int DIO_Pressure = 5;
    public static final int DIO_LauncherBotm = 12;
    
    public static final int DIO_LDriveEncA = 1;
    public static final int DIO_LDriveEncB = 2;
    public static final int DIO_RDriveEncA = 14;
    public static final int DIO_RDriveEncB = 13;
    
    public static int Sol_Shifter = 1;
    public static int Sol_WinchPist = 2;
    public static int Sol_Arm = 3;
    public static int Sol_BallGuard = 4;
    public static int Sol_Grippers = 4;
    public static int Sol_Ejector = 5;
    
}
