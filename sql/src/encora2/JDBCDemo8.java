package encora2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Savepoint;

public class JDBCDemo8 {
public JDBCDemo8() {
	// TODO Auto-generated constructor stub
}
public static void main(String[] args) {
	Connection con=ConnectionPool.getConnection();
	Savepoint sp=null;
	try {
	
	//con.setAutoCommit(false);
	PreparedStatement ps=
			con.prepareStatement("update employees set salary=? where eid=?");
	ps.setFloat(1, 100);
	ps.setInt(2, 100);
	
	ps.executeUpdate();
	// s1	
	sp=con.setSavepoint("s1");
	
	ps.setFloat(1, 50);
	ps.setInt(7, 400);
	ps.executeUpdate();
	
	//con.commit();
	}catch(Exception e) {
		e.printStackTrace();
		try{ConnectionPool.closeConnection(e,sp);}catch(Exception ee) {ee.printStackTrace();}
		//try{con.rollback();}catch(Exception ee) {ee.printStackTrace();}
	}finally {
		
		try{ConnectionPool.closeConnection(null,null);}catch(Exception ee) {ee.printStackTrace();}
	}
}
}