package controllers;

import application.Constants;
import businessObjects.*;
import dal.DBManager;
import gui.ManageBooksForm;

public class SaveController {

	public void saveBook(String bookType, String bookId, String bookName, String author, String publisher, String isbn, String noOfPages, String field1) {

		DBManager dbMgr = new DBManager();
		
		Book book;
		if(bookType.equals(Constants.PRINTBOOK))
		{
			book = new Printbook(Integer.parseInt(bookId), bookName, author, publisher, isbn, Integer.parseInt(noOfPages), Integer.parseInt(field1));
			dbMgr.savePrintbook(book);
		}
		else
		{
			book = new Ebook(Integer.parseInt(bookId), bookName, author, publisher, isbn, Integer.parseInt(noOfPages), field1);
			dbMgr.saveEbook(book);
		}
		
	}

}
