package dal;

import java.sql.*;

import businessObjects.Book;
import businessObjects.Ebook;
import logger.ErrorLogger;

public class GetEbook extends GetBook{
	
	public GetEbook(int id)
	{
		super(id);
	}
	
	public void queryDB()
	{
		try
		{
			String qStr = "SELECT * FROM ebooks WHERE ebook_id=\"" + id + "\"";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
			resultSet = null;
		}
	}
	
	public Book processResult()
	{
		try
		{
			book = new Ebook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
			return book;
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
			return null;
		}
	}
}
