package encora2;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo1 {
	public static void main(String[] args) {
		// JDB connection
		/*
		 * Step 1 -> Register the driver
		 * Step 2 -> Establish Connection
		 * Step 3 -> Create a sql statement
		 * Step 4 -> Execute and process
		 */
		/* Connection con = null;
		
		try {
			// after jdk 6, you don't need to load the driver
			 Class.forName("com.mysql.cj.jdbc.Driver");
			
			/*
			 *  url -> jdbc - protocol
			 *  mysql - database driver
			 *  localhost - host where MYSQL is running (don't need to specify if using default localhost)
			 *  encora - database name
			 */
			// getConnection ( URL where database is running, user, password)
			/* con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {con.close();}catch(Exception e) {}
		} */
		
		// Instead of calling finally, you can directly call/pass in the try and return what you want, so you don't need to add finally now
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
			System.out.println(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
