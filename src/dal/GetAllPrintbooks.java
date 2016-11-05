package dal;

import java.sql.*;
import java.util.ArrayList;
import businessObjects.*;
import logger.ErrorLogger;

public class GetAllPrintbooks extends GetAllBooks{
	
	public void queryDB()
	{
		try
		{
			String qStr = "SELECT * FROM printbooks;";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
			resultSet = null;
		}
	}
	
	public void undoQueryDB()
	{
		
	}
	
	public Book processResult()
	{

		bookList = new ArrayList<Book>();
		
		try
		{
			while(resultSet.next())
			{
				bookList.add(new Printbook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7)));	
			}
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return null;
		
	}
}
