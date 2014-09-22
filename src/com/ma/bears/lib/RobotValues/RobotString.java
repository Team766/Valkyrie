package com.ma.bears.lib.RobotValues;

public class RobotString extends RobotValue{
	
	String value;

	public RobotString(String key, String stringval) {
		super(key);
		this.value = stringval;
	}
	
	public String getValue(){
		return value;
	}
	
	public void setValue(String in){
		value = in;
	}
	
	public String toString(){
		return super.getKey() + ": " + value;
	}

}
