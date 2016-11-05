package controllers;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import application.Constants;
import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;
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

	public DefaultTableModel getAllBooks(String bookType)
	{
		DBManager dbMgr = new DBManager();
		DefaultTableModel model = new DefaultTableModel();
		ArrayList<Book> bookList;		
		
		if(bookType.equals(Constants.PRINTBOOK))
		{
			bookList = dbMgr.getAllPrintbooks();
			
			model.addColumn("Printbook Id");
			model.addColumn("Printbook Name");
			model.addColumn("Author");
			model.addColumn("Publisher");
			model.addColumn("ISBN");
			model.addColumn("Number of Pages");
			model.addColumn("Number of Copies");
			
			for (Book book : bookList) 
			{
				Vector<String> vect = new Vector<String>();
				vect.add(String.valueOf(book.getBookId()));
				vect.add(book.getBookName());
				vect.add(book.getAuthor());
				vect.add(book.getPublisher());
				vect.add(book.getIsbn());
				vect.add(String.valueOf(book.getNoOfPages()));
				vect.add(String.valueOf(((Printbook)book).getNoOfCopies()));
				model.addRow(vect);
			}
			
		}
		else
		{
			bookList = dbMgr.getAllEbooks();
			
			model.addColumn("Ebook Id");
			model.addColumn("Ebook Name");
			model.addColumn("Author");
			model.addColumn("Publisher");
			model.addColumn("ISBN");
			model.addColumn("Number of Pages");
			model.addColumn("Url");
			
			for (Book book : bookList) 
			{
				Vector<String> vect = new Vector<String>();
				vect.add(String.valueOf(book.getBookId()));
				vect.add(book.getBookName());
				vect.add(book.getAuthor());
				vect.add(book.getPublisher());
				vect.add(book.getIsbn());
				vect.add(String.valueOf(book.getNoOfPages()));
				vect.add(((Ebook)book).getUrl());
				model.addRow(vect);
			}
		}
		
		return model;
	}
}
