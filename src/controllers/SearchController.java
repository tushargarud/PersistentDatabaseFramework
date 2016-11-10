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

	public ArrayList<String> searchBook(String bookType, String bookId, String bookName, String author, String publisher, String isbn, String noOfPages, String field1) 
	{	
		
		DBManager dbMgr = new DBManager();	
		Book book;
		
		if(bookType.equals(Constants.PRINTBOOK))
		{
			book = new Printbook(toInteger(bookId), bookName, author, publisher, isbn, toInteger(noOfPages), toInteger(field1));
			book = dbMgr.getPrintbook(book);
		}
		else
		{
			book = new Ebook(toInteger(bookId), bookName, author, publisher, isbn, toInteger(noOfPages), field1);
			book = dbMgr.getEbook(book);
		}

		ArrayList<String> result = new ArrayList<String>();

		if(book!=null)
		{
			result.add(Integer.toString(book.getBookId()));
			result.add(book.getBookName());
			result.add(book.getAuthor());
			result.add(book.getPublisher());
			result.add(book.getIsbn());
			result.add(Integer.toString(book.getNoOfPages()));
			if(bookType.equals(Constants.PRINTBOOK))
				result.add(Integer.toString(((Printbook)book).getNoOfCopies()));
			else
				result.add(((Ebook)book).getUrl());
		}
		
		return result;
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

	private int toInteger(String str)
	{
		if(str==null)
			return -1;
		else if(str.isEmpty())
			return -1;
		
		try
		{
			return Integer.parseInt(str);
		}
		catch(Exception NumberFormatException)
		{
			return -1;
		}
	}

}
