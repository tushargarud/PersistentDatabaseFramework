package dal;

import businessObjects.Book;

public abstract class GetAllBooks extends MysqlImplCmd{
	
	public GetAllBooks()
	{
		
	}
	
	public Book getBook()
	{
		return book;
	}

}
