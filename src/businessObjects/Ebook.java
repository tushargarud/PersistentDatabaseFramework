package businessObjects;

public class Ebook extends Book{
	
	String url;
	
	public Ebook(int bookId, String bookName, String author, String publisher, String isbn, int noOfPages, String url)
	{
		super(bookId, bookName, author, publisher, isbn, noOfPages);
		this.setUrl(url);		
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
