package encora2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.time.LocalDate;

public class DebitDemo {
	public static void main(String[] args) throws Exception {

		Connection con = ConnectionPool.getConnection();
		Savepoint sp = null;

		try {
			PreparedStatement ps = con.prepareStatement("select salary from employees where eid=?");
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter empid : ");
			int eid = Integer.parseInt(bf.readLine());
			ps.setInt(1, eid);
			ResultSet rs = ps.executeQuery();
			int salary = 0;
			while (rs.next()) {
				salary = rs.getInt(1);
				System.out.println("Money in account: " + salary);
			}
			sp = con.setSavepoint("s1");
			
			try {
				String status = "Transaction failed !!"; 
				LocalDate today_Date = LocalDate.now();
				// String Formatted_Date = today_Date.format(DateTimeFormatter.ofPattern("YYYY-MM-DD"));
				PreparedStatement ps3 = con.prepareStatement("insert into log values(? , ? , ?)");
				ps3.setInt(3, eid);
				ps3.setString(1, status);
				ps3.setDate(2, java.sql.Date.valueOf(today_Date));
				ps3.executeUpdate();
				sp=con.setSavepoint();
			} catch(Exception e1) {
				e1.printStackTrace();
			}

			try {
				BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter amount you want to debit: ");
				int amount = Integer.parseInt(bf1.readLine());
				int rem_amount = salary-amount;
				if (rem_amount > 0) {
					PreparedStatement ps2 = con.prepareStatement("update employees set salary=? where eid=?");
					ps2.setInt(1, rem_amount);
					ps2.setInt(2, eid);
					ps2.executeUpdate();
					System.out.println("Amount debited successfully !!!");
					sp=con.setSavepoint();
					try {
						PreparedStatement ps4 = con.prepareStatement("update log set description=? where log_id=?");
						ps4.setInt(2, eid);
						ps4.setString(1, "Transaction success!!!");
						ps4.executeUpdate();
					} catch(Exception eee) {
						eee.printStackTrace();
						try {
							ConnectionPool.closeConnection(eee, sp);
						} catch(Exception eeee) {
							eeee.printStackTrace();
						}
						
					}
				} else {
					throw new Exception("Amount is larger than your bank amount. Please try again later!!!");
				}

			} catch (Exception ee) {
				ee.printStackTrace();
				try {
					ConnectionPool.closeConnection(ee, sp);
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			try {
				ConnectionPool.closeConnection(e, sp);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				ConnectionPool.closeConnection(null, null);
			} catch(Exception exp) {
				exp.printStackTrace();
			}
		}
	}
}
