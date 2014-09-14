package com.ma.bears.lib;

import com.ma.bears.Valkyrie.RobotValues;

public class CSVRunner {

	public static void main(String[] args) {
		CSVInput yay = new CSVInput("file:///C:/Users/Nick/robotics/roboticsjavaworkspace/Valkyrie/src/com/ma/bears/RobotValues.csv");
		yay.readValues();
		//System.out.println(((RobotValue)yay.getInts().elementAt(0)).toString());
		//System.out.println(((RobotValue)yay.getDoubles().elementAt(0)).toString());
		//System.out.println(((RobotValue)yay.getStrings().elementAt(0)).toString());		
		RobotValues.initRobotValues();
		RobotValues.writeFromCSV(yay.getInts(), yay.getDoubles(), yay.getStrings());
		System.out.println("ArmWheels_In" + RobotValues.getDouble("ArmWheels_In"));
		System.out.println("ArmWheels_Out" + RobotValues.getDouble("ArmWheels_Out"));
		System.out.println("ShooterGripWait" + RobotValues.getDouble("ShooterGripWait"));
		System.out.println(RobotValues.getInt("Auton_Max"));
		System.out.println(RobotValues.getInt("Auton_Min"));
	}

}





