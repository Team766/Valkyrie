package com.ma.bears.lib;

import com.ma.bears.lib.RobotValues.RobotDouble;
import com.ma.bears.lib.RobotValues.RobotInt;
import com.ma.bears.lib.RobotValues.RobotString;
import com.ma.bears.lib.RobotValues.RobotValue;
import com.sun.squawk.io.BufferedReader;
import com.sun.squawk.microedition.io.FileConnection;

import javax.microedition.io.Connector;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 * CSV input reader. Reads data from a CSV on the robot and provides
 * the data in 3 Vectors, one each for ints, doubles, and strings.
 * These 3 vectors should be overwritten over what exists in RobotValues.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */

public class CSVInput {
	private Vector doubles;
	private Vector ints;
	private Vector strings;
	private BufferedReader reader;
	
	public CSVInput(String path){
		
		try {
			FileConnection C = (FileConnection) Connector.open(path);
			reader = new BufferedReader(new InputStreamReader(C.openInputStream()));
		} catch (IOException e) {
			//Log.println(e.toString());
			//Log.println("failed to open CSV file " + path);
		}
		doubles = new Vector();
		ints = new Vector();
		strings = new Vector();
	}
	
	public void readValues(){
		doubles = new Vector();
		ints = new Vector();
		strings = new Vector();
		
		//This code here hopefully works with Java ME on the crio,
		//but cannot be tested on desktop
		//They build fine
		try {
			String data = "";
			while((data = reader.readLine()) != null){
				String key = data.substring(0, data.indexOf(","));
				String value = data.substring(data.indexOf(",") + 1);
				addValuetoVector(key, value);
			}
		} catch (IOException e) {
			//Log.println(e.toString());
			//Log.println("failed to read data from CSV file");
		}
		
		//These here are testing dummy vector adds while we can't actually read from CSV.
		
		/*addValuetoVector("menlo","12");
		addValuetoVector("atherton","12.00");
		addValuetoVector("bears","twelve");
		
		addValuetoVector("ArmWheels_In", "5.0");
		addValuetoVector("ArmWheels_Out", "" + Math.PI);
		addValuetoVector("ShooterGripWait","67.9");
		addValuetoVector("Auton_Max","100");
		addValuetoVector("Auton_Min","-254");*/
		
	}
	
	/**
	 * Creates the RobotValue object from readValues' outputs and 
	 * adds these to a Vector.
	 * @param key key of value
	 * @param value the method parses whether it's an int, double or string
	 */
	private void addValuetoVector(String key, String value){
		RobotValue toAdd;
		try{
			toAdd = new RobotInt(key,Integer.parseInt(value));
			ints.addElement(toAdd);
		}catch(NumberFormatException e){
			try{
				toAdd = new RobotDouble(key,Double.parseDouble(value));
				doubles.addElement(toAdd);
			}catch(NumberFormatException i){
				toAdd = new RobotString(key, value);
				strings.addElement(toAdd);
			}
		}
	}
	
	public Vector getDoubles(){
		return doubles;
	}
	
	public Vector getInts(){
		return ints;
	}
	
	public Vector getStrings(){
		return strings;
	}

}
