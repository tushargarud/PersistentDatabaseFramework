package businessObjects;

public class Printbook extends Book{
	
	int noOfCopies;
	
	public Printbook(int bookId, String bookName, String author, String publisher, String isbn, int noOfPages, int noOfCopies)
	{
		super(bookId, bookName, author, publisher, isbn, noOfPages);
		this.setNoOfCopies(noOfCopies);		
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

}
