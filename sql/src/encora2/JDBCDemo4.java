package encora2;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Sql statement is created after the statement created
 * But sql statement can be created along with the prepared statement -> You can execute the statements multiple time
 */

public class JDBCDemo4 {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
			// ? is being added so that it can be replaced later, we don't take separate variable and add like + eid, because it is not good for security
			PreparedStatement ps = con.prepareStatement("select*from employees where eid=?");
			
			// bufferedReader is class in java that is used to read text from an input stream like file or keyboard input
			// it wraps around reader like InputStreamReader or FileReader
			BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				System.out.println("Please enter emploee id... ");
				int eid = Integer.parseInt(in.readLine());
				ps.setInt(1, eid);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					// we can either pass column name or column index
					System.out.println(rs.getString("eid"));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
