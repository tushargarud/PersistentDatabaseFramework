package dal;

import businessObjects.Book;

public abstract class GetBook extends MysqlImplCmd{
	
	public GetBook(Book book)
	{
		super(book);
	}
	
	public Book getBook()
	{
		return book;
	}

}
