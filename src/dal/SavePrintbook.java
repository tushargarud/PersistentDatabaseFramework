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
			String qStr;
			qStr = "SELECT printbook_id FROM printbooks WHERE printbook_id=\"" + book.getBookId() + "\"";
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
				qStr = "INSERT INTO librarydatabse.printbooks VALUES (" + book.getBookId() +", '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', " + book.getNoOfPages() + ", " + ((Printbook)book).getNoOfCopies() + ");";
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

}
