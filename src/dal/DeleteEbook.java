package dal;

import java.sql.SQLException;

import businessObjects.Book;
import businessObjects.Ebook;
import logger.ErrorLogger;

public class DeleteEbook extends DeleteBook{
	
	public DeleteEbook(int id)
	{
		super(id);
	}
	
	public void queryDB()
	{
		String qStr;
		
		try
		{			
			qStr= "SELECT * FROM ebooks WHERE ebook_id=\"" + id + "\"";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
			
			qStr = "DELETE FROM ebooks WHERE ebook_id=\"" + id + "\"";
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
			qStr = "INSERT INTO librarydatabse.ebooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Ebook)book).getUrl() + "');";
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
				book = new Ebook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
		
	}
}
