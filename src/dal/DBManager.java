package dal;

import java.util.ArrayList;

import businessObjects.Book;

public class DBManager {
	
	DBImpl dbImpl = new MysqlImpl();
	
	public void savePrintbook(Book b)
	{
		dbImpl.savePrintbook(b);
	}
	
	public void saveEbook(Book b)
	{
		dbImpl.saveEbook(b);
	}
		
	public Book getPrintbook(int id)
	{
		return dbImpl.getPrintbook(id);
	}
	
	public Book getEbook(int id)
	{
		return dbImpl.getEbook(id);
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
