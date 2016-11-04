package dal;

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
			String qStr = "INSERT INTO librarydatabse.ebooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Ebook)book).getUrl() + "');";
			stmt = con.createStatement();
			stmt.executeQuery(qStr);
		}
		catch(Exception ex)
		{
			stmt = null;
			ErrorLogger.log(ex.getMessage());
		}
	}
}
