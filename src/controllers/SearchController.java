package controllers;

import application.Constants;
import businessObjects.Book;
import dal.DBManager;

public class SearchController {

	public Book searchBook(String bookType, int id) {

		DBManager dbMgr = new DBManager();

		if(bookType.equals(Constants.PRINTBOOK))
		{
			return dbMgr.getPrintbook(id);
		}
		else
		{
			return dbMgr.getEbook(id);
		}
	}
}
