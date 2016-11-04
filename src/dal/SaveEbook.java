package dal;

import java.sql.Statement;

import businessObjects.Book;
import businessObjects.Ebook;

public class SaveEbook extends SaveBook{
	
	public SaveEbook(Book book)
	{
		super(book);
	}
	
	public void queryDB()
	{
		//check syntax of the query
		String qStr = "INSERT INTO librarydatabse.ebooks VALUES ('" + book.getBookId() +"', '" + book.getBookName() + "', '" + book.getAuthor() + "', '" + book.getPublisher() + "', '" + book.getIsbn() + "', '" + book.getNoOfPages() + "', '" + ((Ebook)book).getUrl() + "');";
		stmt = con.createStatement();
		stmt.executeQuery(qStr);
	}

}
