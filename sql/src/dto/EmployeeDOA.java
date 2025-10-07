package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDOA implements EmployeeDOAImpl<EmployeeDTO> {
	Connection con;
	private EmployeeDTO emp = null;

	public EmployeeDOA(Connection con) {
		this.con = con;
	}

	public void closeConnection(Exception e, Savepoint sp) throws Exception {
		ConnectionUtility.closeConnection(e, sp);
	}

	public EmployeeDTO findById(int id) throws Exception {
//		try {
			PreparedStatement ps = con.prepareStatement("select * from employees where eid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				emp = new EmployeeDTO();
				emp.setEid(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setDeptid(rs.getInt(4));
				emp.setCity(rs.getString(5));
				emp.setSalary(rs.getInt(6));
			} else {
				throw new IllegalArgumentException();
			}

//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return emp;
	}

	public List<EmployeeDTO> getAll() throws Exception {
		List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		ResultSet rs = con.createStatement().executeQuery("select * from employees");
		while (rs.next()) {
			emp = new EmployeeDTO();
			emp.setEid(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setDeptid(rs.getInt(4));
			emp.setCity(rs.getString(5));
			emp.setSalary(rs.getInt(6));

			list.add(emp);
		}
		return list;
	}

	public void insert(EmployeeDTO emp) throws Exception {
		PreparedStatement ps = con.prepareStatement("insert into employees values(?, ?, 'encora' , ?, ?, ?)");
		ps.setInt(1, emp.getEid());
		ps.setString(2, emp.getName());
		ps.setInt(3, emp.getDeptid());
		ps.setString(4, emp.getCity());
		ps.setInt(5, emp.getSalary());

		ps.executeUpdate();
	}

	public void delete(EmployeeDTO emp) throws Exception {
		PreparedStatement ps = con.prepareStatement("delete from employees where eid=?");
		ps.setInt(1, emp.getEid());
		ps.executeUpdate();
	}

	public void update(EmployeeDTO emp) throws Exception {
		PreparedStatement ps = con
				.prepareStatement("update employees set ename=?, deptid=?, city=?, salary=? where eid=?");
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getDeptid());
		ps.setString(3, emp.getCity());
		ps.setInt(4, emp.getSalary());
		ps.setInt(5, emp.getEid());

		ps.executeUpdate();
	}
}
