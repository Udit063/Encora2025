package dto;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Optional;
import java.util.Properties;

public class ConnectionUtility {
	private static ThreadLocal<Connection> tlocal = new ThreadLocal<>();
	private static Connection con;
	private static Properties prop;
	static {
		prop = new Properties();
		try {
			prop.load(new FileInputStream("dbconfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public static Connection getConnection() {
		con = tlocal.get();
		Optional.ofNullable(con).ifPresentOrElse(n -> {
		}, () -> {
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			try {
				con = DriverManager.getConnection(url, username, password);
				con.setAutoCommit(false);
				tlocal.set(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return con;

	}

	synchronized public static void closeConnection(Exception ex, Savepoint sp) throws Exception {
		con = tlocal.get();
		Optional.ofNullable(con).ifPresent((c) -> {
			Optional.ofNullable(ex).ifPresentOrElse(n -> {
				Optional.ofNullable(sp).ifPresentOrElse(nn -> {
					try {
						con.rollback(nn);
						con.commit();
						con.close();
						tlocal.remove();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}, () -> {
				});
			}, () -> {
				try {
					con.commit();
					con.close();
					tlocal.remove();
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		});

	}
}
