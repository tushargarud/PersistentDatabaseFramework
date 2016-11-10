package dal;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import businessObjects.Book;
import businessObjects.Ebook;
import businessObjects.Printbook;
import logger.ErrorLogger;

public class GetPrintbook extends GetBook{

	public GetPrintbook(Book book)
	{
		super(book);		
	}

	public void queryDB()
	{
		try
		{
								
			Printbook pbook = (Printbook)book;
			
			ArrayList<String> conditions = new ArrayList<String>();
			if(pbook.getBookId() > 0)
				conditions.add("printbook_id=" + Integer.toString(pbook.getBookId()));
			if(pbook.getBookName() != null && !pbook.getBookName().isEmpty())
				conditions.add("printbook_name LIKE '%"+pbook.getBookName()+"%'");
			if(pbook.getAuthor() != null && !pbook.getAuthor().isEmpty())
				conditions.add("author LIKE '%"+pbook.getAuthor()+"%'");
			if(pbook.getPublisher() != null && !pbook.getPublisher().isEmpty())
				conditions.add("publisher LIKE '%"+pbook.getPublisher()+"%'");
			if(pbook.getIsbn() != null && !pbook.getIsbn().isEmpty())
				conditions.add("isbn LIKE '%"+pbook.getIsbn()+"%'");
			if(pbook.getNoOfPages() > 0)
				conditions.add("number_of_pages=" + Integer.toString(pbook.getNoOfPages()));
			if(pbook.getNoOfCopies() > 0)
				conditions.add("number_of_copies=" + Integer.toString(pbook.getNoOfCopies()));
			
			StringBuilder condition = new StringBuilder("SELECT * FROM printbooks WHERE ");
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
				book = new Printbook(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4),resultSet.getString(5),resultSet.getInt(6),resultSet.getInt(7));
		}
		catch(SQLException ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		
		return book;
	}

}
