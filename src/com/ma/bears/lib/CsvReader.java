package com.ma.bears.lib;
import java.io.*;
import java.util.*;

/*
 * Supplies robot values to the robot values class.  Reads the values from the values.txt file 
 * and turns the strings into ints.  First create the file, then ftp into it and change the 
 * numbers
 * 
 * Created by Brett Levenson
 */

public class CsvReader {
	//private Scanner scan;
	private int forwardDist = 0;
	private int timeDist = 0;
	private int oneBallDist = 0;
	private int oneBallTime = 0;
	
	
	public void openFile()
	{
		/*try
		{
			scan = new Scanner(new File("values.txt"));
		}
		catch(Exception e)
		{
			System.out.println("WE ARE GOING TO DIE!!!!!");
		}*/
	}
	
	public void readFile()
	{
		/*while(scan.hasNext())
		{
			int name = scan.nextInt();
			int value = scan.nextInt();
			int valueb = scan.nextInt();
			
			switch(name)
			{
			case 1:
				forwardDist = value;
				timeDist = valueb;
			case 2:
				oneBallDist = value;
				oneBallTime = valueb;
			}
			
		}*/
	}
	
	public void closeFile()
	{
		//scan.close();
	}
	
	public final int getforwardDist(){ return forwardDist;}
	public final int gettimeDist(){ return timeDist;}
	public final int getoneBallDist(){ return oneBallDist;}
	public final int getoneBallTime(){ return oneBallTime;}
}
 