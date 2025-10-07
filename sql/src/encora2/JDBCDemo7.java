package encora2;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCDemo7 {
	public static void main(String[] args)throws Exception {
		Connection con = ConnectionPoolPractice.getConnections();
		try {
			PreparedStatement ps = con.prepareStatement("update employees set salary=? where eid=?");
			ps.setFloat(1, 10000);
			ps.setFloat(2, 1);
			ps.executeUpdate();
			
			ps.setFloat(1, 50);
			ps.setInt(3, 400);
			ps.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
//				ConnectionPoolPractice.closeConnections(e);
				ConnectionPoolPractice.closeConnections();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		} finally {
			try {
//				ConnectionPoolPractice.closeConnections(null);
				ConnectionPoolPractice.closeConnections();
			} catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
