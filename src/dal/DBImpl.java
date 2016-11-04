package dal;
import businessObjects.Book;

public interface DBImpl {
	public void savePrintbook(Book b);
	public void saveEbook(Book b);
	public Book getPrintbook(int id);
	public Book getEbook(int id);
}
