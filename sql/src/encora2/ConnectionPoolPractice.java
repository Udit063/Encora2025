package encora2;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionPoolPractice {
	private static ThreadLocal<Connection> tlocal = new ThreadLocal<Connection>();
	private static Connection con;
	private static Properties prop;
	
	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("dbConfig.properties"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnections() throws Exception{
		con = tlocal.get();
		if(con == null) {
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String passowrd = prop.getProperty("password");
			con=DriverManager.getConnection(url, username, passowrd);
		}
		return con;
	}
	
	public static void closeConnections() throws Exception{
		con = tlocal.get();
		if(con!=null) {
			con.close();
			tlocal.remove();
		}
	}
	
	
}
