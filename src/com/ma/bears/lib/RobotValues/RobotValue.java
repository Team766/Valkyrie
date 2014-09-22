package com.ma.bears.lib.RobotValues;

/**
 * Class for a RobotValue such as a motor speed
 * or PID constant. Contains a key and its value,
 * for re-writing from CSV file.
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 */
public class RobotValue {
	
	private String key;
	
	public RobotValue(String key){
		this.key = key;
	}
	
	/**
	 * @return the key that the variable is stored as
	 */
	public String getKey(){
		return key;
	}
	
	public String toString(){
		return key;
	}

}
