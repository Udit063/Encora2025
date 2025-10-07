package encora2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JDBCDemo6 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			try {
				Connection con = ConnectionPoolPractice.getConnections();
				System.out.println("Thread1.... : " + con );
				ConnectionPoolPractice.closeConnections();
				System.out.println("Thread11.... : " + ConnectionPool.getConnection() );
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
		
		es.execute(()->{
			try {
				Connection con = ConnectionPoolPractice.getConnections();
				System.out.println("Thread2.... : "+con);
				Thread.sleep(3000);
				System.out.println("Thread22.... : "+con);
			} catch(Exception e) {
				e.printStackTrace();
			}
		});
	}
}
