package encora2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemoPractice3 {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
			Statement stmt = con.createStatement();
			String sql = "select * from employees";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("eid"));
			}
			
			sql = "update employees set deptid=102 where eid=1";
			ResultSet rs2 = stmt.executeQuery(sql);
			int i = stmt.executeUpdate(sql);
			while(rs2.next()) {
				System.out.println(rs2.getString("eid"));
				System.out.println(rs2.getString("deptid"));
			}
		} catch(Exception e) {
			
		}
	}
}
