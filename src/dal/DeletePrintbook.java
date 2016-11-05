package dal;

import java.sql.SQLException;

import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;
import logger.ErrorLogger;

public class DeletePrintbook extends DeleteBook{
	
	public DeletePrintbook(int id)
	{
		super(id);
	}
	
	public void queryDB()
	{
		String qStr;
		
		try
		{
			qStr= "SELECT * FROM printbooks WHERE printbook_id=\"" + id + "\"";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
			
			qStr = "DELETE FROM printbooks WHERE printbook_id=\"" + id + "\"";
			stmt = con.createStatement();
			stmt.executeUpdate(qStr);
		}
		catch(Exception ex)
		{
			stmt = null;
			ErrorLogger.log(ex.getMessage());
		}
	}
	
	public void undoQueryDB()
	{
		String qStr;
		
		try
		{			
			qStr = "INSERT INTO librarydatabse.printbooks VALUES (" + book.getBookId() +", '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', " + book.getNoOfPages() + ", " + ((Printbook)book).getNoOfCopies() + ");";
			stmt = con.createStatement();
			stmt.executeUpdate(qStr);				
		}
		catch(Exception ex)
		{
			stmt = null;
			ErrorLogger.log(ex.getMessage());
		}
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
