package com.ma.bears;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 
public class CsvReader {
	
	//instance vars
	private int forwardDist = 0;
	private int timeDist = 0;

  public void run() {
 
	String csvFile = "/CsvTest.csv";
	BufferedReader br = null;
	String line = "";
 
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			
		    // use comma as separator
			String[] input = line.split(",");
			int[] values = new int[input.length];

			for (int i = 1; i < input.length; i++) {
			    try {
			        values[i] = Integer.parseInt(input[i]);
			    } catch (NumberFormatException nfe) {};
			}
			switch(values[1]){
			case 1:
				forwardDist = values[1];
				timeDist = values[2];
				System.out.println("1 Ball hot Auton");
				break;
			case 2:
				forwardDist = values[1];
				timeDist = values[2];
				System.out.println("2 Ball hot Auton");
				break;
			default:
				System.out.println("No Auton");
			}
			//System.out.println("Index: " + input[0] + input[1] + input[2] + input[3] + input[4]);
			//System.out.println("Values: " + values[0] + values[1] + values[2] + values[3] + values[4]);
 
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
 
	System.out.println("CSV Reader is Done");
  }
  
  public int getforwardDist(){ return forwardDist;}
  public int gettimeDist(){ return timeDist;}
 
}