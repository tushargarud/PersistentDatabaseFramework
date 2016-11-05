package dal;

import java.sql.SQLException;
import java.sql.Statement;

import businessObjects.Book;
import businessObjects.Ebook;
import logger.ErrorLogger;

public class SaveEbook extends SaveBook{
	
	public SaveEbook(Book book)
	{
		super(book);
	}
	
	public void queryDB()
	{
		try
		{
			String qStr;
			qStr = "SELECT * FROM ebooks WHERE ebook_id=\"" + book.getBookId() + "\"";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
			
			if(resultSet.next())
			{
				qStr = "UPDATE librarydatabse.ebooks SET ebook_id='" + book.getBookId() +"', ebook_name='" + book.getBookName() + "', author='" + book.getAuthor() + "', publisher='" + book.getPublisher() + "', isbn='" + book.getIsbn() + "', number_of_pages='" + book.getNoOfPages() + "', url='" + ((Ebook)book).getUrl() + "' WHERE ebook_id='" + book.getBookId() + "';";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);
			}
			else
			{
				id = book.getBookId();
				resultSet=null;
				qStr = "INSERT INTO librarydatabse.ebooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Ebook)book).getUrl() + "');";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);				
			}
						
		}
		catch(Exception ex)
		{
			stmt = null;
			ErrorLogger.log(ex.getMessage());
		}
	}
	
	public void undoQueryDB()
	{
		try
		{
			String qStr;			
			
			if(book!=null)
			{
				qStr = "SELECT * FROM ebooks WHERE ebook_id=\"" + book.getBookId() + "\"";
				stmt = con.createStatement();
				resultSet = stmt.executeQuery(qStr);
				resultSet.next();
				
				qStr = "UPDATE librarydatabse.ebooks SET ebook_id='" + book.getBookId() +"', ebook_name='" + book.getBookName() + "', author='" + book.getAuthor() + "', publisher='" + book.getPublisher() + "', isbn='" + book.getIsbn() + "', number_of_pages='" + book.getNoOfPages() + "', url='" + ((Ebook)book).getUrl() + "' WHERE ebook_id='" + book.getBookId() + "';";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);
				
			}
			else
			{
				qStr = "SELECT * FROM ebooks WHERE ebook_id=\"" + id + "\"";
				stmt = con.createStatement();
				resultSet = stmt.executeQuery(qStr);
				resultSet.next();
				
				qStr = "DELETE FROM ebooks WHERE ebook_id=\"" + id + "\"";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);
			}
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
			if(resultSet!=null)
				book = new Ebook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
		
	}
}
