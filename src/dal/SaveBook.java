package dal;

import businessObjects.Book;

public abstract class SaveBook extends MysqlImplCmd{
	
	public SaveBook(Book book)
	{
		this.book = book;		
	}

}
