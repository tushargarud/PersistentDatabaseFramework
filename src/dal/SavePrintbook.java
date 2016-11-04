package dal;

import java.sql.Statement;

import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;

public class SavePrintbook extends SaveBook{
	
	public SavePrintbook(Book book)
	{
		super(book);
	}
	
	public void queryDB()
	{
		//check syntax of the query
		String qStr = "INSERT INTO librarydatabse.printbooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Printbook)book).getNoOfCopies() + "');";
		stmt = con.createStatement();
		stmt.executeQuery(qStr);		
	}

}
