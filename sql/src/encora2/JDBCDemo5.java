package encora2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

// Callable statements are used to call the procedures created in sql
public class JDBCDemo5 {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost/encora", "root", "root");){
//			CallableStatement cs =con.prepareCall("{call proc1()}");
//			cs.execute();
			
			/*
			 * CallableStatement cs2 = con.prepareCall("{call proc2(?)}");
			// (index, type of what will get returned)
			cs2.registerOutParameter(1, Types.INTEGER);
			cs2.execute();
			
			int n = cs2.getInt(1);
			System.out.println("No. of rows in employees table : " + n);
			 */
			
			CallableStatement cs3 = con.prepareCall("{call proc3(?,?)}");
//			cs3.setInt(1, 2)
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter employee id : ");
			int eid = Integer.parseInt(bf.readLine());
			cs3.setInt(1, eid);
			cs3.registerOutParameter(2, Types.VARCHAR);
			cs3.execute();
			System.out.println("Name for the employee id " + eid + " is " + " = " + cs3.getString(2));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * Procedure are used as a function in sql so that we don't have to write the
 * same query again and again and we can reuse the command
 * 
 * First change delimiter to something (using delimiter //), as ; will be used
 * after sql statement also and it is also used to end the procedure, so we have
 * to change the delimiter mysql> create procedure proc1() -> begin -> insert
 * into employees values (4, 'rancho', 'abc', 104, 'ladakh', 1000000); -> insert
 * into employees values (5, 'rambo', 'abcde', 105, 'manali', 100000); -> end//
 * 
 * mysql> call proc1();
 */