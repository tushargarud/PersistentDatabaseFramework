package dal;

import java.util.ArrayList;

import businessObjects.Book;
import components.ExecutedStack;

public class MysqlImpl implements DBImpl {
	
	public void savePrintbook(Book b)
	{
		SavePrintbook s = new SavePrintbook(b);
		s.execute();
		ExecutedStack.push(s);
	}
	
	public void saveEbook(Book b)
	{
		SaveEbook s = new SaveEbook(b);
		s.execute();
		ExecutedStack.push(s);
	}
	
	public Book getPrintbook(int id)
	{
		GetPrintbook g = new GetPrintbook(id);
		g.execute();
		ExecutedStack.push(g);
		return g.getBook();		
	}
	
	public Book getEbook(int id)
	{
		GetEbook g = new GetEbook(id);
		g.execute();
		ExecutedStack.push(g);
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
		ExecutedStack.push(g);
		return g.getAllBooks();
	}
	
	public ArrayList<Book> getAllEbooks()
	{
		GetAllEbooks g = new GetAllEbooks();
		g.execute();
		ExecutedStack.push(g);
		return g.getAllBooks();
	}
}
