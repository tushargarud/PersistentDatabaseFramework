package dal;

import businessObjects.Book;

public abstract class GetBook extends MysqlImplCmd{
	
	public GetBook(int id)
	{
		super(id);
	}
	
	public Book getBook()
	{
		
	}

}
