package encora2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class JDBCExample {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
			CallableStatement cs = con.prepareCall("{call GetMostRecentJoinDate(?)}");
			cs.registerOutParameter(1, Types.DATE);
			cs.execute();
			
			System.out.println("Recent joining date : " + cs.getString(1));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
