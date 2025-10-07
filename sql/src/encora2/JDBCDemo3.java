package encora2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCDemo3 {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
			Statement stmt = con.createStatement();
			String sql = "select * from employees";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("eid"));
				System.out.println(rs.getString("ename"));
			}
			
			System.out.println();
			
			sql = "update employees set deptid=300";
			int i = stmt.executeUpdate(sql);
			System.out.println("No of rows updated: " + i);
			
			// True will come if return is there otherwise it will show false
			// sql = "create table users (uid int(5), flag int(1))";
			sql = "select* from users";
			System.out.println(stmt.execute(sql));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
