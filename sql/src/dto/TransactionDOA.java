package dto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionDOA implements EmployeeDOAImpl<TransactionDTO> {
	Connection con;
	private TransactionDTO log = null;
	LocalDate date = LocalDate.now();
	
	public TransactionDOA(Connection con) {
		this.con = con;
	}

	public void closeConnection(Exception e, Savepoint sp) throws Exception {
		ConnectionUtility.closeConnection(e, sp);
	}
	
	public TransactionDTO findById(int id) throws Exception{
		PreparedStatement ps = con.prepareStatement("select * from log where log_id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			log = new TransactionDTO();
			log.setDescription(rs.getString(1));
			log.setDate(rs.getDate(2));
			log.setLogid(rs.getInt(3));
		}  else {
			throw new IllegalArgumentException();
		}
		return log;
	}
	
	public void insert(TransactionDTO log) throws Exception {
		PreparedStatement ps = con.prepareStatement("insert into log values(?, ?, ? )");
		ps.setString(1, "Transaction failed!!!");
		ps.setDate(2, Date.valueOf(date));
		ps.setInt(3, log.getLogid());
		ps.executeUpdate();
	}
	
	public void delete(TransactionDTO log) throws Exception{
		PreparedStatement ps = con.prepareStatement("delete from log where log_id=?");
		ps.setInt(1, log.getLogid());
		ps.executeUpdate();
	}
	
	public void update(TransactionDTO log) throws Exception{
		PreparedStatement ps = con.prepareStatement("update log set description=? where log_id=?");
		ps.setString(1, "Transaction success!!!");
		ps.setInt(2, log.getLogid());
		ps.executeUpdate();
	}
	
	public List<TransactionDTO> getAll() throws Exception{
		List<TransactionDTO> list = new ArrayList<TransactionDTO>();
		ResultSet rs = con.createStatement().executeQuery("select * from log");
		while(rs.next()) {
			log = new TransactionDTO();
			log.setDescription(rs.getString(1));
			log.setDate(rs.getDate(2));
			log.setLogid(rs.getInt(3));
			
			list.add(log);
		}
		return list;
		
	}
	
}
