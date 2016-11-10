package dal;

import java.util.ArrayList;

import businessObjects.Book;

public class DBManager {
	
	DBImpl dbImpl = new MysqlImpl();
	
	public void savePrintbook(Book book)
	{
		dbImpl.savePrintbook(book);
	}
	
	public void saveEbook(Book book)
	{
		dbImpl.saveEbook(book);
	}
		
	public Book getPrintbook(Book book)
	{
		return dbImpl.getPrintbook(book);
	}
	
	public Book getEbook(Book book)
	{
		return dbImpl.getEbook(book);
	}
	
	public void deletePrintbook(int id)
	{
		dbImpl.deletePrintbook(id);
	}
	
	public void deleteEbook(int id)
	{
		dbImpl.deleteEbook(id);
	}
	
	public ArrayList<Book> getAllPrintbooks()
	{
		return dbImpl.getAllPrintbooks();
	}
	
	public ArrayList<Book> getAllEbooks()
	{
		return dbImpl.getAllEbooks();
	}

}
