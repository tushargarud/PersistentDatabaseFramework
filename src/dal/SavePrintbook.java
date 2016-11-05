package dal;

import java.sql.SQLException;
import businessObjects.Book;
import businessObjects.Printbook;
import logger.ErrorLogger;

public class SavePrintbook extends SaveBook{
	
	public SavePrintbook(Book book)
	{
		super(book);
	}
	
	public void queryDB()
	{
		try
		{
			String qStr;
			qStr = "SELECT * FROM printbooks WHERE printbook_id=\"" + book.getBookId() + "\"";
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(qStr);
			
			if(resultSet.next())
			{
				qStr = "UPDATE librarydatabse.printbooks SET printbook_id='" + book.getBookId() +"', printbook_name='" + book.getBookName() + "', author='" + book.getAuthor() + "', publisher='" + book.getPublisher() + "', isbn='" + book.getIsbn() + "', number_of_pages='" + book.getNoOfPages() + "', number_of_copies='" + ((Printbook)book).getNoOfCopies() + "' WHERE printbook_id='" + book.getBookId() + "';";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);
			}
			else
			{
				id = book.getBookId();
				resultSet=null;
				qStr = "INSERT INTO librarydatabse.printbooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Printbook)book).getNoOfCopies() + "');";
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
				qStr = "SELECT * FROM printbooks WHERE printbook_id=\"" + book.getBookId() + "\"";
				stmt = con.createStatement();
				resultSet = stmt.executeQuery(qStr);
				resultSet.next();
				
				qStr = "UPDATE librarydatabse.printbooks SET printbook_id='" + book.getBookId() +"', printbook_name='" + book.getBookName() + "', author='" + book.getAuthor() + "', publisher='" + book.getPublisher() + "', isbn='" + book.getIsbn() + "', number_of_pages='" + book.getNoOfPages() + "', number_of_copies='" + ((Printbook)book).getNoOfCopies() + "' WHERE printbook_id='" + book.getBookId() + "';";
				stmt = con.createStatement();
				stmt.executeUpdate(qStr);
				
			}
			else
			{
				qStr = "SELECT * FROM printbooks WHERE printbook_id=\"" + id + "\"";
				stmt = con.createStatement();
				resultSet = stmt.executeQuery(qStr);
				resultSet.next();
				
				qStr = "DELETE FROM printbooks WHERE printbook_id=\"" + id + "\"";
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
				book = new Printbook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
		
	}
}
