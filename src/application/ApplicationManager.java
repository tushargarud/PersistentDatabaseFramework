package application;

import controllers.*;
import gui.ManageBooksForm;
import logger.ErrorLogger;

public class ApplicationManager {
	
	private static SaveController saveController;
	private static SearchController searchController;
	private static DeleteController deleteController;
	
	public ApplicationManager()
	{
		ErrorLogger.initialize();
		saveController = new SaveController();
		searchController = new SearchController();
		deleteController = new DeleteController();
		
		ManageBooksForm manageBooksForm  = new ManageBooksForm(); 
		manageBooksForm.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		ApplicationManager applicationManager = new ApplicationManager();		
	}
	  
	public static SaveController getSaveController() {
		return saveController;
	}

	public static SearchController getSearchController() {
		return searchController;
	}

	public static DeleteController getDeleteController() {
		return deleteController;
	}	

}
