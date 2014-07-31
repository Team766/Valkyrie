package com.ma.bears;

/**
 * Because FRC's PID only supports a 
 * narrow range of things - you have to
 * send the output directly to 
 * speed controller, etc.
 * 
 * <p>Possibly later we may 
 * create a second class
 * that allows for different PID constants
 * depending on which direction - 
 * this might be useful for things like arms 
 * where behavior is different depending
 * on direction.
 * 
 * 
 * @author Nicky Ivy nickivyca@gmail.com
 *
 */

public class PIDController {
	
	private double Kp = 0;
	private double Ki = 0;
	private double Kd = 0;
	private double maxoutput_low = 0;
	private double maxoutput_high = 0;
	private double endthreshold = 0;
	
	private double setpoint = 0;

	private double cur_error = 0;
	private double prev_error = 0;
	private double total_error = 0;
	
	private double output_value = 0;
	
	/**
	 * 
	 * @param P P constant
	 * @param I I constant
	 * @param D D constant
	 * @param outputmax_low Largest output in the negative direction
	 * @param outputmax_high Largest output in the positive direction
	 * @param threshold threshold for declaring the PID 'done'
	 */	
	public PIDController (double P, double I, double D, double outputmax_low, 
			double outputmax_high, double threshold){
		Kp = P;
		Ki = I;
		Kd = D;
		maxoutput_low = outputmax_low;
		maxoutput_high = outputmax_high;
		endthreshold = threshold;
	}
	
	/**
	 * We may want to use same PID object,
	 * but with different setpoints, so this is separated
	 * from constructor
	 * @param set Target point to match
	 */
	public void setSetpoint(double set){
		setpoint = set;
	}
	
	/**
	 * Calculate PID value. Run only once per loop. Use 
	 * getOutput to get output.
	 * @param cur_input Input from sensor
	 */
	public void calculate(double cur_input){
		if(isDone()){
			output_value = 0;
			return;
		}
		double cur_error = (setpoint - cur_input);
		double out = Kp * cur_error + Ki * total_error + Kd * (cur_error - prev_error);
		prev_error = cur_error;
		total_error += cur_error;
		output_value = clip(out);
	}
	
	public double getOutput(){
		return output_value;
	}
	
	public boolean isDone(){
		if (cur_error < endthreshold)
			return true;
		return false;
	}
	
	/**
	 * Reset all accumulated errors
	 */
	public void reset(){
		cur_error = 0;
		prev_error = 0;
		total_error = 0;
	}
	
	/**
	 * Clips value for sending to speed controllers.
	 * This deals with if you don't want to
	 * run an arm or wheels at full speed under
	 * PID.
	 * @param clipped 
	 * @return clipped value, safe for setting to controllers
	 */
	private double clip(double clipped){
		double out = clipped;
		if (out > maxoutput_high)
			out = maxoutput_high;
		if(out < maxoutput_low)
			out = maxoutput_low;
		return out;
	}

}