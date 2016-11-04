package controllers;

import java.sql.*;

import businessObjects.Book;
import gui.ManageBooksForm;
import logger.ErrorLogger;

public class EditController {

	public static void main(String[] args) {
		final String DRIVER = "com.mysql.jdbc.Driver";  
		final String URL = "jdbc:mysql://localhost:3306/librarydatabse?autoReconnect=true&useSSL=false";
		final String USERNAME = "scott";
		final String PASSWORD = "tiger";

		Connection conn = null;
		Statement stmt = null;
		
		ErrorLogger.initialize();

		try
		{
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM printbooks";
			ResultSet rs = stmt.executeQuery(sql);
		
			while(rs.next())  
			{
				Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				ManageBooksForm manageBooksForm = new ManageBooksForm(book);
				manageBooksForm.setVisible(true);
			}
			rs.close();
			stmt.close();
			conn.close();

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			ErrorLogger.closeErrorLog();
		}

	}

}
