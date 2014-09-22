package com.ma.bears.Valkyrie;

import java.util.Vector;

import com.ma.bears.lib.RobotValues.RobotDouble;
import com.ma.bears.lib.RobotValues.RobotInt;
import com.ma.bears.lib.RobotValues.RobotString;

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
	
    /*public static final double ArmWheels_In = 1.0;
    public static final double ArmWheels_Out = -1.0;
    public static final double WinchSpeed = -0.9;
    public static final double ShooterWait = 0.75;
    public static final double ShooterGripWait = 0.1;*/
	
	public static Vector RobotDoubles = new Vector();
	public static Vector RobotInts = new Vector();
	public static Vector RobotStrings = new Vector();
    
    //cheesy drive
    public static final double sensitivityHigh = .85;
    public static final double sensitivityLow = .75;
    
    //drive
    public static final double Kp = 0.4;
    public static final double Kd = 0.2;
    public static final double driveTolerance = .01;
    
    //gyro turning
    
    public static final double AngleKp = 0.3;
    public static final double AngleKi = 0.0;
    public static final double AngleKd = 0.0;
    public static final double Angleoutputmax_low = -0.3;
    public static final double Angleoutputmax_high = 0.3;
    public static final double AngleThreshold = 1;
    
    //drive straight
    
    public static final double DriveKp = 0.0;
    public static final double DriveKi = 0.0;
    public static final double DriveKd = 0.0;
    public static final double Driveoutputmax_low = -0.5;
    public static final double Driveoutputmax_high = 0.5;
    public static final double DriveThreshold = .01;
    
    public static final double StraightKp = 0.0;
    public static final double StraightKi = 0.0;
    public static final double StraightKd = 0.0;
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
    public static final int Auton_CheesyForwardVision = 10;
    //if you increment the values above you must also increment the Auton_Max
        
    public static final int Auton_Max = 10;
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
    
    public static void initRobotValues(){
    	RobotDoubles.addElement(new RobotDouble("ArmWheels_In",1.0));
    	RobotDoubles.addElement(new RobotDouble("ArmWheels_Out",-1.0));
    	RobotDoubles.addElement(new RobotDouble("WinchSpeed",-0.9));
        RobotDoubles.addElement(new RobotDouble("ShooterWait",0.9));
        RobotDoubles.addElement(new RobotDouble("ShooterGripWait",0.1));
        
        RobotInts.addElement(new RobotInt("Auton_Disabled",-1));
        RobotInts.addElement(new RobotInt("Auton_Empty",0));
        RobotInts.addElement(new RobotInt("Auton_OneBallStay",1));
        RobotInts.addElement(new RobotInt("Auton_TwoBall",2));
        RobotInts.addElement(new RobotInt("Auton_Move",3));
        RobotInts.addElement(new RobotInt("OneBallMove",4));
        RobotInts.addElement(new RobotInt("Auton_CheesyVision",5));
        RobotInts.addElement(new RobotInt("Auton_GyroDriveTurn",6));
        RobotInts.addElement(new RobotInt("Auton_HotOneBallStay",7));
        RobotInts.addElement(new RobotInt("Auton_HotOneBallMove",8));
        RobotInts.addElement(new RobotInt("Auton_THREEBALLHOT",9));
        RobotInts.addElement(new RobotInt("Auton_Max",9));
        RobotInts.addElement(new RobotInt("Auton_Min",-1));
        
    }
    
    /**
     * Writes values from CSVReader into RobotValues. For each value in each array, it looks
     * for a value with a matching key in RobotValues' arrays.
     */
    public static void writeFromCSV(Vector ints, Vector doubles, Vector strings){
    	for(int i = 0; i <= ints.size()-1; i++){
    		RobotInt currenttest = ((RobotInt)ints.elementAt(i));
        	for(int x = 0; x <= RobotInts.size()-1; x++){
        		if(((RobotInt)RobotInts.elementAt(x)).getKey().equals(currenttest.getKey())){
        			RobotInts.setElementAt(currenttest, x);
        		}
        	}
    	}
    	for(int i = 0; i <= doubles.size()-1; i++){
    		RobotDouble currenttest = ((RobotDouble)doubles.elementAt(i));
        	for(int x = 0; x <= RobotDoubles.size()-1; x++){
        		if(((RobotDouble)RobotDoubles.elementAt(x)).getKey().equals(currenttest.getKey())){
        			RobotDoubles.setElementAt(currenttest, x);
        		}
        	}
    	}
    	for(int i = 0; i <= strings.size()-1; i++){
    		RobotString currenttest = ((RobotString)strings.elementAt(i));
        	for(int x = 0; x <= RobotStrings.size()-1; x++){
        		if(((RobotString)RobotStrings.elementAt(x)).getKey().equals(currenttest.getKey())){
        			RobotStrings.setElementAt(currenttest, x);
        		}
        	}
    	}
    }
    
    /**
     * Return int from array
     * @param key key of number
     */
    public static int getInt(String key){
    	for(int i = 0; i <= RobotInts.size()-1; i++){
                System.out.println(((RobotInt)RobotInts.elementAt(i)).getKey());
    		if(((RobotInt)RobotInts.elementAt(i)).getKey().equals(key))
    			return ((RobotInt)RobotInts.elementAt(i)).getValue();
        }
    	//Log.println("Reading int " + key + " failed");
    	System.out.println("Reading int " + key + " failed");
    	return 0;
    }

    
    /**
     * Return double from array
     * @param key key of number
     */
    public static double getDouble(String key){
    	for(int i = 0; i <= RobotDoubles.size()-1; i++){
    		if(((RobotDouble)RobotDoubles.elementAt(i)).getKey().equals(key))
    			return ((RobotDouble)RobotDoubles.elementAt(i)).getValue();
    	}
    	//Log.println("Reading double " + key + " failed");
    	System.out.println("Reading double " + key + " failed");
    	return 0;
    }
}
