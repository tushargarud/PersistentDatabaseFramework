package dal;

import java.sql.SQLException;
import java.sql.Statement;

import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;
import logger.ErrorLogger;

public class GetPrintbook extends GetBook{

	public GetPrintbook(int id)
	{
		super(id);		
	}

	public void queryDB()
	{
		try
		{
			String qStr = "SELECT * FROM printbooks WHERE printbook_id=" + id + ";";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
		}
		catch(Exception ex)
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
		book = null;
		
		try
		{
			if(resultSet.next())
				book = new Printbook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
	}

}
