package week33;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
 
public class ArrayListDemo3 {
	public static void main(String[] args) {
		List<Student12> list=new ArrayList<Student12>();
		list.add(new Student12("ramu",450));
		list.add(new Student12("somu",450));
		list.add(new Student12("salman",420));
		list.add(new Student12("sharukh",420));
		System.out.println(list);
		list.sort((s1,s2)->{return s1.compareTo(s2);});
		System.out.println(list);
		
		list.forEach(System.out::println);
		list.forEach((s)->System.out.println(s));
		
	}
}
class MySupplier implements Supplier<Integer>{
	@Override
	public Integer get() {
		// TODO Auto-generated method stub
		return null;
	}
}
class Student12 implements Comparable<Student12>{
	String name;
	int marks;
	public Student12(String name,int marks) {
		this.name=name;this.marks=marks;
	}
	@Override
	public int compareTo(Student12 o) {
//		int result=this.marks-o.marks;
//		if(result==0) {
//			result=this.name.compareTo(o.name);
//		}
//		return result;
		return Optional.of(this.marks-o.marks)
		.filter((n)->{return n!=0;})
		.orElseGet(()->{return this.name.compareTo(o.name);});	
	}    
	@Override
	public String toString() {
		return name+":"+marks;
	}
}

