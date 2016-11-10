package dal;

import java.util.ArrayList;

import businessObjects.Book;
import components.ExecutedStack;

public class MysqlImpl implements DBImpl {
	
	public void savePrintbook(Book book)
	{
		SavePrintbook s = new SavePrintbook(book);
		s.execute();
		ExecutedStack.push(s);
	}
	
	public void saveEbook(Book book)
	{
		SaveEbook s = new SaveEbook(book);
		s.execute();
		ExecutedStack.push(s);
	}
	
	public Book getPrintbook(Book book)
	{
		GetPrintbook g = new GetPrintbook(book);
		g.execute();
		return g.getBook();		
	}
	
	public Book getEbook(Book book)
	{
		GetEbook g = new GetEbook(book);
		g.execute();
		return g.getBook();
	}
	
	public void deletePrintbook(int id)
	{
		DeletePrintbook d = new DeletePrintbook(id);
		d.execute();
		ExecutedStack.push(d);
	}
	
	public void deleteEbook(int id)
	{
		DeleteEbook d = new DeleteEbook(id);
		d.execute();
		ExecutedStack.push(d);
	}
	
	public ArrayList<Book> getAllPrintbooks()
	{
		GetAllPrintbooks g = new GetAllPrintbooks();
		g.execute();
		return g.getAllBooks();
	}
	
	public ArrayList<Book> getAllEbooks()
	{
		GetAllEbooks g = new GetAllEbooks();
		g.execute();
		return g.getAllBooks();
	}
}
