package dal;

import java.sql.*;

import businessObjects.Book;
import logger.ErrorLogger;

public abstract class MysqlImplCmd {

	protected int id;
	protected Book book;

	protected Connection con;
	protected Statement stmt;
	protected ResultSet resultSet;
	
	public MysqlImplCmd()
	{
		//default constructor required for creating objects of SaveBook
	}
	
	public MysqlImplCmd(Book book)
	{
		this.book = book;
	}
	
	public void execute()
	{
		try
		{
			if(connectDB())
			{
				queryDB();
				book = processResult();
			}
		}
		catch(Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		finally
		{
			disconnectDB();
		}
	}
	
	public void undo()
	{
		try
		{
			if(connectDB())
			{
				undoQueryDB();
				book = processResult();
			}
		}
		catch(Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
		}
		finally
		{
			disconnectDB();
		}	
	}
	
	public abstract void queryDB();
	
	public abstract void undoQueryDB();
	
	public abstract Book processResult();
	
	public boolean connectDB()
	{
		try
		{
			Class.forName(DBConfig.getInstance().getDriver());
			con = DriverManager.getConnection(DBConfig.getInstance().getUrl(),DBConfig.getInstance().getUsername(),DBConfig.getInstance().getPassword());
			return true;
		}
		catch(Exception ex)
		{
			ErrorLogger.log(ex.getMessage());
			return false;
		}
	}
	
	public void disconnectDB()
	{
		try
		{
			try
			{
				try
				{
					if(resultSet!=null)
						resultSet.close();
				}
				finally
				{
					if(stmt!=null)
						stmt.close();
				}
			}
			finally
			{
				if(!con.isClosed())
					con.close();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
	}
	
}
