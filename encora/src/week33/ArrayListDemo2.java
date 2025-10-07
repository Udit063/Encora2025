package week33;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		List<Student1> list=new ArrayList<Student1>();
		list.add(new Student1("ramu",450));
		list.add(new Student1("somu",340));
		list.add(new Student1("salman",420));
		list.add(new Student1("sharukh",420));
		System.out.println(list);
//		list.sort((s1, s2)->{
//			return s2.compareTo(s1);
//		});
		Collections.sort(list);
//		System.out.println(list);

		System.out.println(list);
	}
}
class Student1 implements Comparable<Student1>{
	String name;
	int marks;
	public Student1(String name,int marks) {
		this.name=name;this.marks=marks;
	}
	@Override 
	public int compareTo(Student1 obj) {
		// TODO Auto-generated method stub
		return this.marks - obj.marks;
	}
	@Override
	public String toString() {
		return name+":"+marks;
	}
}
