package dal;

import businessObjects.Book;

public abstract class DeleteBook extends MysqlImplCmd{
	
	public DeleteBook(int id)
	{
		this.id = id;	
	}
	
	public Book processResult()
	{
		return null;
	}

}
