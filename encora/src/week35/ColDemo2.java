package week35;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ColDemo2 {
	public static void main(String[] args) {
//		Set<Employee> myset = new HashSet<Employee>();
//		Set<Employee> myset = new TreeSet<Employee>(); // always sort in ascending order but accepts compareTo method
		Set<Employee> myset = new TreeSet<Employee>((o1,o2)->o2.compareTo(o1));  // accepts comparator for descending order
		myset.add(new Employee("ramu", 20));
		myset.add(new Employee("ramu", 20));
		myset.add(new Employee("amitabh", 70));
		myset.add(new Employee("kishore", 50));
		myset.add(new Employee("amit", 20));


		
		System.out.println(myset);
		
	}
}

class Employee implements Comparable<Employee>{
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	String name;
	int age;
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override 
	public String toString() {
		return this.name + " : " + this.age;
	}
	
	@Override
	public int compareTo(Employee o) {
//		int result = this.name.compareTo(o.name);
//		if(result==0) {
//			return this.age - o.age;
//		} else {
//			return result;
//		}
		
		
//		Optional.of(null).filter(new MyPredicate(this, o))
		
		return Optional.ofNullable(this.name.compareTo(o.name))
		.filter((n)-> n!=0)
		.orElseGet(()-> this.age - o.age);
		
//		return Optional.of(o)
//			.filter(new MyPredicate(this, o))
//			.orElseGet(new MySupplier(this, o));
		
	}
	
	
	// without lambda you have to write this extra so much code
	class MyPredicate implements Predicate<Employee>{
		Employee e1, e2;
		public MyPredicate(Employee e1, Employee e2) {
			this.e1=e1;
			this.e2=e2;
		}
		
		@Override
		public boolean test(Employee e) {
			return e1.name.compareTo(e2.name)!=0;
		}
		
	}
	
	class MySupplier implements Supplier<Integer>{
		Employee e1, e2;
		public MySupplier(Employee e1, Employee e2) {
			this.e1=e1;
			this.e2=e2;
		}
		
		@Override
		public Integer get() {
			return e1.age-e2.age;
		}
	}
}
