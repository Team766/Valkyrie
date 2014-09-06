package com.ma.bears.Valkyrie;

/**
 * Declare robot values, such as default speed of a motor,
 * in a convenient place that allows us to change them
 * quickly without sorting through code.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 * @author Brett Levenson
 */
public class RobotValues {
	
	/*
	 * The 'front' of the robot is pickup. Keep that in
	 * mind for distances.
	 */
	
    public static final double ArmWheels_In = 1;
    public static final double ArmWheels_Out = -1;
    public static final double WinchSpeed = -0.9;
    public static final double ShooterWait = 0.75;
    public static final double ShooterGripWait = 0.1;
    
    //cheesy drive
    public static final double sensitivityHigh = .85;
    public static final double sensitivityLow = .75;
    
    //drive
    public static final double Kp = 0.4;
    public static final double Kd = 0.2;
    public static final double driveTolerance = .01;
    
    //gyro turning
    
    public static final double AngleKp = 0.3;
    public static final double AngleKi = 0;
    public static final double AngleKd = 0;
    public static final double Angleoutputmax_low = -0.3;
    public static final double Angleoutputmax_high = 0.3;
    public static final double AngleThreshold = 1;
    
    //drive straight
    
    public static final double DriveKp = 0;
    public static final double DriveKi = 0;
    public static final double DriveKd = 0;
    public static final double Driveoutputmax_low = -0.5;
    public static final double Driveoutputmax_high = 0.5;
    public static final double DriveThreshold = .01;
    
    public static final double StraightKp = 0;
    public static final double StraightKi = 0;
    public static final double StraightKd = 0;
    public static final double Straightoutputmax_low = -0.1;
    public static final double Straightoutputmax_high = 0.1;
    public static final double StraightThreshold = .000001; //so it never stops trying
    
    //Auton    
            
    public static final int Auton_Disabled = -1;
    public static final int Auton_Empty = 0;
    public static final int Auton_OneBallStay = 1;
    public static final int Auton_TwoBall = 2;
    public static final int Auton_Move = 3;
    public static final int Auton_OneBallMove = 4;
    public static final int Auton_CheesyVision = 5;  
    public static final int Auton_GyroDriveTurn = 6;
    public static final int Auton_HotOneBallStay = 7;
    public static final int Auton_HotOneBallMove = 8;
    public static final int Auton_THREEBALLHOT = 9;
    //if you increment the values above you must also increment the Auton_Max
        
    public static final int Auton_Max = 9;
    public static final int Auton_Min = -1;
    
    //Auton distances negative because we are driving backwards
    
    public static final double OneBallStay_shootDistance = 0.0;
    public static final double OneBallStay_crossDistance = 2.0;
    
    public static final double Move_Distance = 2.0;
    
    public static final double TwoBall_PickupTime = 1.0;
    public static final double TwoBall_Shot1Distance = 0.0;
    public static final double TwoBall_WaitforShoot = 2.0;
    public static final double TwoBall_Shot2Distance = 1.2;
    
    public static final double OneBallMove_Distance = 2.6;
}
