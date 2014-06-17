package com.ma.bears.Valkyrie;

/**
 * Declare robot values, such as default speed of a motor,
 * in a convenient place that allows us to change them
 * quickly without sorting through code.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Blevenson
 */
public class RobotValues {
	
	//Make all distances forward negative and backwards positive
	
    public static final double ArmWheels_In = 1;
    public static final double ArmWheels_Out = -1;
    public static final double WinchSpeed = -0.9;
    public static final double ShooterWait = 0.75;
    
    //cheesy drive
    public static final double sensitivityHigh = .85;
    public static final double sensitivityLow = .75;
    
    //drive
    public static final double Kp = 10.0;
    public static final double Kd = 0.8;
    public static final double driveTolerance = .01;
    
    //Auton    
            
    public static final int Auton_Disabled = -1;
    public static final int Auton_Empty = 0;
    public static final int Auton_OneBallStay = 1;
    public static final int Auton_TwoBall = 2;
    public static final int Auton_Move = 3;
    public static final int Auton_OneBallMove = 4;
    public static final int Auton_CheesyVision = 5;
        
    public static final int Auton_Max = 5;
    
    //Auton distances negative because we are driving backwards
    
    public static final double OneBallStay_shootDistance = 0.0;
    public static final double OneBallStay_crossDistance = -1.0;
    
    public static final double Move_Distance = -2.0;
    
    public static final double TwoBall_PickupTime = 1.0;
    public static final double TwoBall_Shot1Distance = 0;
    public static final double TwoBall_WaitforShoot = 2.0;
    public static final double TwoBall_Shot2Distance = -1.2;
    
    public static final double OneBallMove_Distance = -2.6;
}
