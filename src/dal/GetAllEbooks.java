package dal;

import java.sql.*;
import java.util.ArrayList;

import businessObjects.Book;
import businessObjects.Ebook;
import logger.ErrorLogger;

public class GetAllEbooks extends GetAllBooks{
	
	public void queryDB()
	{
		try
		{
			String qStr = "SELECT * FROM ebooks;";
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
				bookList.add(new Ebook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7)));	
			}
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return null;
		
	}
}
