package com.ma.bears.lib;
import com.sun.squawk.io.BufferedWriter;
import com.sun.squawk.microedition.io.FileConnection;

import javax.microedition.io.Connector;

//import java.io.File;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/*
 * Used to store print outs for testing.  File can then be accessed through FTP so
 * the driver station isn't needed.  Used along with the print outs.  Allows us
 * to see what happened and what went wrong.
 * 
 * Created by Brett Levenson
 */

public class logData 
{
	private BufferedWriter writer;
	
	/**
	 * Creates the log file.  Called once at the start of the match.
	 */
	public logData()
	{
		try {
			FileConnection C = (FileConnection) Connector.open("file://log.txt");
			writer = new BufferedWriter(new OutputStreamWriter(C.openOutputStream()));
			//File file = new File("log.txt");
		    //file.createNewFile();
			//writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e) {
			System.out.println("failed to open CSV file:///log.txt");
			System.out.println(e.toString());
		}
	}
	/**
	 * @param print Message
	 * Puts a String message into the log.
	 */
	public void print(String message)
	{
		try {
			writer.write(message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("I 2 stupid 2 no how 2 wite");
		}
	}
	/**
	 * @param print Message with data
	 * Puts a String message and a value into the log.
	 */
	public void print(String message, int value)
	{
		try {
			writer.write(message + value + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("I 2 stupid 2 no how 2 wite");
		}
	}
	
	/**
	 * Closes and saves the file.  Called when the match ends.
	 */
	public void closeFile()
	{
		try {
			writer.close();
			
			System.out.println("Closed");
		} catch (IOException e) {
			System.out.println("Whoops! Butter fingers. I dropped the file. \n Can't close log");
			e.printStackTrace();
		}
	}

}
