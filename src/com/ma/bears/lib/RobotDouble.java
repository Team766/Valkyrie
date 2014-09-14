package com.ma.bears.lib;

public class RobotDouble extends RobotValue{
	
	private double value;

	public RobotDouble(String key, double doubleval) {
		super(key);
		this.value = doubleval;
	}
	
	public double getValue(){
		return value;
	}
	
	public void setValue(double in){
		value = in;
	}
	
	public String toString(){
		return super.getKey() + ": " + value;
	}

}
