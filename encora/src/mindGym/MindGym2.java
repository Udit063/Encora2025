package mindGym;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;
public class MindGym2 {
	/*
	 * Operators
	 * 1. Arithmetic operator
	 * 2. Relational operator
	 * 3. Logical operators
	 */
	void met() {
		//Arithmetic operator - +, -, *, / , %
		int i=10;
		int j=3;
		System.out.println(i%j);//1 - Reminder
		System.out.println(i/j);;//3 - quotient
		
		i=i+10;
		i+=10;
		
		//Relational operator - <, >, ==, >=,<=, !=
		
		//Logical operators - &&, ||
		
		if(i==10 && j< 5) {}//if both the conditions are satisfied then it returns true
		//truth table for AND
			//true true = true
			//true false = false
			//false true = false
			//false false = false
		//truth table for OR
			//true true = true
			//true false = true
			//false true = true
			//false false = false
		
	}
	public static void main(String[] args) {
		//Escape Sequences
		System.out.println("hello \t world");
		System.out.println("hello \"world\" ");
		System.out.println("hello \'world\' ");
		System.out.println("hello\bworld");//back space
		System.out.println("hellooooooooooo\rworld");
		int i=0;
		while(true) {
			System.out.print("\r"+(i++));  // overwrite from the start 
		}
	}
}
class EmployeDTO implements Serializable, Comparable<EmployeDTO>{
	private int empNo;
	private String empName;
	private String deptName;
	transient private int empAge;
	@Override
	public int compareTo(EmployeDTO o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public EmployeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeDTO(int empNo, String empName, String deptName, int empAge) {
		this.empNo = empNo;
		this.empName = empName;
		this.deptName = deptName;
		this.empAge = empAge;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	@Override
	public int hashCode() {
		return Objects.hash(deptName, empAge, empName, empNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeDTO other = (EmployeDTO) obj;
		return Objects.equals(deptName, other.deptName) && empAge == other.empAge
				&& Objects.equals(empName, other.empName) && empNo == other.empNo;
	}
	@Override
	public String toString() {
		return "EmployeVO [empNo=" + empNo + ", empName=" + empName + ", deptName=" + deptName + ", empAge=" + empAge
				+ "]";
	}	
}
