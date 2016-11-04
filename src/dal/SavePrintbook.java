package dal;

import java.sql.Statement;

import businessObjects.Book;
import businessObjects.Ebook;
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
			String qStr = "INSERT INTO librarydatabse.printbooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Printbook)book).getNoOfCopies() + "');";
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
