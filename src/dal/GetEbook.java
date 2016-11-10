package dal;

import java.sql.*;
import java.util.ArrayList;

import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;
import logger.ErrorLogger;

public class GetEbook extends GetBook{
	
	public GetEbook(Book book)
	{
		super(book);
	}
	
	public void queryDB()
	{
		try
		{
								
			Ebook ebook = (Ebook)book;
			
			ArrayList<String> conditions = new ArrayList<String>();
			if(ebook.getBookId() > 0)
				conditions.add("ebook_id=" + Integer.toString(ebook.getBookId()));
			if(ebook.getBookName() != null && !ebook.getBookName().isEmpty())
				conditions.add("ebook_name LIKE '%"+ebook.getBookName()+"%'");
			if(ebook.getAuthor() != null && !ebook.getAuthor().isEmpty())
				conditions.add("author LIKE '%"+ebook.getAuthor()+"%'");
			if(ebook.getPublisher() != null && !ebook.getPublisher().isEmpty())
				conditions.add("publisher LIKE '%"+ebook.getPublisher()+"%'");
			if(ebook.getIsbn() != null && !ebook.getIsbn().isEmpty())
				conditions.add("isbn LIKE '%"+ebook.getIsbn()+"%'");
			if(ebook.getNoOfPages() > 0)
				conditions.add("number_of_pages=" + Integer.toString(ebook.getNoOfPages()));
			if(ebook.getUrl() != null && !ebook.getUrl().isEmpty())
				conditions.add("url LIKE '%"+ebook.getUrl()+"%'");
			
			StringBuilder condition = new StringBuilder("SELECT * FROM ebooks WHERE ");
			for(String str : conditions)
			{
				if(conditions.indexOf(str)==0)
					condition.append(str + " ");
				else
					condition.append(" and " + str + " ");
			}
			condition.append(";");
			
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(condition.toString());
		}
		catch(Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
			resultSet = null;
		}
	}
	
	public void undoQueryDB()
	{
		
	}
	
	public Book processResult()
	{

		book = null;
		
		try
		{
			if(resultSet.next())
				book = new Ebook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getString(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
		
	}
}
