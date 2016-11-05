package application;

import java.awt.Dimension;
import java.awt.Toolkit;

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
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        manageBooksForm.setLocation((screenDimension.width-manageBooksForm.getWidth())/2, (screenDimension.height-manageBooksForm.getHeight())/2);
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
