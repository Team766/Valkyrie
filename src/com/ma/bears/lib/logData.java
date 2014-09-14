package com.ma.bears.lib;
import java.util.*;

/*
 * Used to store print outs for testing.  File can then be accessed through FTP so
 * the driver station isn't needed.  Used along with the print outs.  Allows us
 * to see what happened and what went wrong.
 * 
 * Created by Brett Levenson
 */

public class logData 
{
	//private Formatter x;
	
	/**
	 * Creates the log file.  Called once at the start of the match.
	 */
	public void openFile()
	{
		/*try
		{
			x = new Formatter("logData.txt");
		}
		catch(Exception e)
		{
			System.out.println("Ogh OH!!! ERROR");
		}*/
	}
	/**
	 * @param print Message
	 * Puts a String message into the log.
	 */
	public void addRecords(String message)
	{
		Object theMessage[] = { message };
		//x.format("%s \n", theMessage);
	}
	/**
	 * @param print Message with data
	 * Puts a String message and a value into the log.
	 */
	public void addRecords(String message, int value)
	{
		Object input[] = { message, new Integer(value) };
		//x.format("%s %d \n", input);
	}
	
	/**
	 * Closes and saves the file.  Called when the match ends.
	 */
	public void closeFile()
	{
		//x.close();
	}

}
