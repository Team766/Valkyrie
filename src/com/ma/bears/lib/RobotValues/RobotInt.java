package com.ma.bears.lib.RobotValues;

public class RobotInt extends RobotValue{
	
	private int value;

	public RobotInt(String key, int intval) {
		super(key);
		this.value = intval;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setValue(int in){
		value = in;
	}
	
	public String toString(){
		return super.getKey() + ": " + value;
	}

}
