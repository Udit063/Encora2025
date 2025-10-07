package dto;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Savepoint;
import java.util.List;

public class DebitAmount {
	public static void main(String[] args) {
		Connection con = ConnectionUtility.getConnection();
		EmployeeDOA emp = new EmployeeDOA(con);
		TransactionDOA trans = new TransactionDOA(con);
		TransactionDTO td = new TransactionDTO();
		Savepoint sp = null;

		try {
//			List<EmployeeDTO> list = emp.getAll();
//			for (EmployeeDTO i : list) {
//				System.out.println(i);
//			}
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please enter your eid : ");
			int eid = Integer.parseInt(bf.readLine());
			EmployeeDTO ed = emp.findById(eid);
			ed.setEid(eid);

			int salary = ed.getSalary();
			System.out.println("Amount in your account : " + salary);

			sp = con.setSavepoint();

			BufferedReader bf2 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Please enter you want to debit : ");
			int amount = Integer.parseInt(bf2.readLine());

			td.setLogid(0);
			int i = td.getLogid();
			td.setLogid(++i);
			trans.insert(td);
			sp = con.setSavepoint();

			int rem_amount = salary - amount;
			ed.setSalary(rem_amount);
			emp.update(ed);

			sp = con.setSavepoint();

			td.setDescription("Transaction success !!!");
			trans.update(td);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				ConnectionUtility.closeConnection(e, sp);
			} catch (Exception ee) {
				ee.printStackTrace();
			}
		} finally {
			try {
				ConnectionUtility.closeConnection(null, null);
			} catch(Exception eee) {
				eee.printStackTrace();
			}
		}

	}
}
