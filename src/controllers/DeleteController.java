package controllers;

import application.Constants;
import businessObjects.Book;
import dal.DBManager;

public class DeleteController {

	public void deleteBook(String bookType, int id) {				
		
		DBManager dbMgr = new DBManager();
		
		if(bookType.equals(Constants.PRINTBOOK))
			dbMgr.deletePrintbook(id);
		else
			dbMgr.deleteEbook(id);
		
	}

}
