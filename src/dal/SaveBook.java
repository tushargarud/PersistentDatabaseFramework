package dal;

import businessObjects.Book;

public abstract class SaveBook extends MysqlImplCmd{
	
	public SaveBook(Book book)
	{
		this.book = book;		
	}
	
	public Book processResult()
	{
		return null;
	}

}
