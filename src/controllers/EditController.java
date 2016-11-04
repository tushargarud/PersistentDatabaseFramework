package controllers;

import businessObjects.Book;
import dal.DBManager;
import gui.ManageBooksForm;
import logger.ErrorLogger;

public class EditController {
	
	public static void main(String args[])
	{
		ErrorLogger.initialize();
		
		DBManager dbMgr = new DBManager();
		Book b = dbMgr.getEbook(1);
		ManageBooksForm mbf = new ManageBooksForm(b);
		mbf.setVisible(true);	
	}
	

}
