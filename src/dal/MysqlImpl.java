package dal;

import businessObjects.Book;

public class MysqlImpl implements DBImpl {
	
	public void savePrintbook(Book b)
	{
		SavePrintbook s = new SavePrintbook(b);
		s.execute();
	}
	
	public void saveEbook(Book b)
	{
		SavePrintbook s = new SavePrintbook(b);
		s.execute();
	}
	
	public Book getPrintbook(int id)
	{
		GetPrintbook g = new GetPrintbook(id);
		g.execute();
		return g.getBook();
	}
	
	public Book getEbook(int id)
	{
		GetEbook g = new GetEbook(id);
		g.execute();
		return g.getBook();
	}
}
