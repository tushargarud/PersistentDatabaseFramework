package dal;

import logger.ErrorLogger;

public class DeleteEbook extends DeleteBook{
	
	public DeleteEbook(int id)
	{
		super(id);
	}
	
	public void queryDB()
	{
		try
		{
			String qStr = "DELETE FROM ebooks WHERE ebook_id=\"" + id + "\"";
			stmt = con.createStatement();
			stmt.executeUpdate(qStr);
		}
		catch(Exception ex)
		{
			stmt = null;
			ErrorLogger.log(ex.getMessage());
		}
	}
}
