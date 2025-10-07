package encora2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.Optional;

public class DebitDemoRefactor {
	public DebitDemoRefactor() {

	}

	public static void main(String[] args) {
		Connection con = ConnectionPool.getConnection();
		Savepoint sp = null;
		DebitDemoRefactor d = new DebitDemoRefactor();

		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter eid: ");
			int eid = Integer.parseInt(bf.readLine());
			int salary = d.getSalary(eid, con);
			System.out.println("Money in account: " + salary);
			sp = con.setSavepoint();
			
			d.AddTransactionLog(eid, con, sp);
			
			BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Please enter amount to be debited : ");
			int amount = Integer.parseInt(bf.readLine());
			int rem_amount = salary-amount;
			
			d.DebitAmount(rem_amount, eid, con, sp);
			d.UpdateTransaction(eid, con, sp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ConnectionPool.closeConnection(e, sp);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		} finally {
			try {
				
				ConnectionPool.closeConnection(null, null);
			} catch (Exception eee) {
				eee.printStackTrace();
			}
		}
	}

	public int getSalary(int eid, Connection con) throws Exception {
//		try {
		PreparedStatement ps = con.prepareStatement("select salary from employees where eid=?");
		ps.setInt(1, eid);
		ResultSet rs = ps.executeQuery();
		int s = 0;
		if (rs.next()) {
			s = rs.getInt(1);
		}
		return s;
//		} catch(Exception ex) {
//			ex.printStackTrace();
//			throw new Exception("eid not found!!");
//		}
//		return 0;
	}

	public void AddTransactionLog(int eid, Connection con, Savepoint sp) {
		String status = "Transaction failed!!";
		LocalDate today = LocalDate.now();
		try {
			PreparedStatement ps2 = con.prepareStatement("insert into log values(? , ?, ?)");
			ps2.setString(1, status);
			ps2.setDate(2, java.sql.Date.valueOf(today));
			ps2.setInt(3, eid);
			ps2.executeUpdate();
			sp = con.setSavepoint();
		} catch (Exception ee) {
			ee.printStackTrace();
			try {
				ConnectionPool.closeConnection(ee, sp);
			} catch(Exception eeee) {
				eeee.printStackTrace();
			}
		}
	}

	public void DebitAmount(int rem_amount, int eid, Connection con, Savepoint sp) {
		try {
			if (rem_amount > 0) {
				PreparedStatement ps2 = con.prepareStatement("update employees set salary=? where eid=?");
				ps2.setInt(1, rem_amount);
				ps2.setInt(2, eid);
				ps2.executeUpdate();
				System.out.println("Amount debited successfully !!!");
				sp = con.setSavepoint();
			} else {
				throw new AmountException("Amount can't be larger then your bank balance!!");
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	public void UpdateTransaction(int log_id, Connection con, Savepoint sp) {
		try {
			PreparedStatement ps4 = con.prepareStatement("update log set description=? where log_id=?");
			ps4.setInt(2, log_id);
			ps4.setString(1, "Transaction success!!!");
			ps4.executeUpdate();
		} catch (Exception eee) {
			eee.printStackTrace();
			try {
				ConnectionPool.closeConnection(eee, sp);
			} catch(Exception eeee) {
				eeee.printStackTrace();
				try {
					ConnectionPool.closeConnection(eee, sp);
				} catch(Exception exp) {
					eeee.printStackTrace();
				}
			}
		}

	}

	public class AmountException extends Exception {
		public AmountException(String message) {
			super(message);
		}
	}
}
