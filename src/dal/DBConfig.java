package dal;

// Singleton class
public class DBConfig {
	
	private final String DRIVER;  
	private final String URL;
	private final String USERNAME;
	private final String PASSWORD;
	
	private static DBConfig instance;
	
	private DBConfig()
	{
		DRIVER = "com.mysql.jdbc.Driver";
		URL = "jdbc:mysql://localhost:3306/librarydatabse?autoReconnect=true&useSSL=false";
		USERNAME = "scott";
		PASSWORD = "tiger";
	}
	
	public static DBConfig getInstance()
	{
		if(instance == null)
			instance = new DBConfig();
		
		return instance;
	}
	
	public String getDriver() {
		return DRIVER;
	}

	public String getUrl() {
		return URL;
	}

	public String getUsername() {
		return USERNAME;
	}

	public String getPassword() {
		return PASSWORD;
	}

}
