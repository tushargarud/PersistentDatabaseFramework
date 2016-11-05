package dal;

import logger.ErrorLogger;

public class DeletePrintbook extends DeleteBook{
	
	public DeletePrintbook(int id)
	{
		super(id);
	}
	
	public void queryDB()
	{
		try
		{
			String qStr = "DELETE FROM printbooks WHERE printbook_id=\"" + id + "\"";
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
