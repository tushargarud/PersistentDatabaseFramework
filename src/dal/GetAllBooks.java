package dal;

import java.util.ArrayList;

import businessObjects.Book;

public abstract class GetAllBooks extends MysqlImplCmd{
	
	ArrayList<Book> bookList;
	
	public ArrayList<Book> getAllBooks()
	{
		return bookList;
	}

}
