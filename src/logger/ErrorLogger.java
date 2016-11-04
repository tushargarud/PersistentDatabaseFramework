package logger;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ErrorLogger {
	
	private static PrintWriter writer;
	
	public static void initialize()
	{
		try
		{
			if(writer==null)
				writer = new PrintWriter("ErrorLog.txt");
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("ErrorLog file not found");
		}
	}
	
	public static void initialize(String logFilePath)
	{
		try
		{
			if(writer==null)
				writer = new PrintWriter(logFilePath);
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("ErrorLog file not found");
		}		
	}
	
	public static void log(String errorMessage)
	{
	    writer.println(errorMessage);
	}
	
	public static void closeErrorLog()
	{
	    writer.close();
	}

}
