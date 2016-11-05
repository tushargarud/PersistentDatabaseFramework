package dal;
import java.util.ArrayList;

import businessObjects.Book;

public interface DBImpl {
	public Book getPrintbook(int id);
	public Book getEbook(int id);
	public void savePrintbook(Book b);
	public void saveEbook(Book b);
	public void deletePrintbook(int id);
	public void deleteEbook(int id);
	public ArrayList<Book> getAllPrintbooks();
	public ArrayList<Book> getAllEbooks();
}
