package dto;

import java.sql.Savepoint;
import java.util.List;

public interface EmployeeDOAImpl<T> {
	public void closeConnection(Exception e, Savepoint sp) throws Exception;
	public T findById(int id) throws Exception;
	public List<T> getAll() throws Exception;
	public void insert(T emp) throws Exception;
	public void delete(T emp) throws Exception;
	public void update(T emp) throws Exception;
}
