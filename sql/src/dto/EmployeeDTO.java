package dto;

import java.util.Objects;

public class EmployeeDTO {
	private int eid;
	private String name;
	private int salary;
	private String city;
	private int deptid;
	
	public EmployeeDTO() {
		
	}
	
//	public EmployeeDTO(int eid, String name, String city, int salary, int deptid){
//		this.eid = eid;
//		this.name = name;
//		this.city = city;
//		this.salary = salary;
//		this.deptid = deptid;
//	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, deptid, eid, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(city, other.city) && deptid == other.deptid && eid == other.eid
				&& Objects.equals(name, other.name) && salary == other.salary;
	}
	
}
