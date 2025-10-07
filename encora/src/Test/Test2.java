package Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Test2 {
	Student s=new Student("ramu",10,true);
	@Test
	public void testMethods() {
		assertEquals(10, s.getAge());
		assertNotEquals("adsf", s.getName());
		assertTrue(s.isEnrolled());
		assertFalse(s.getAge()<5);
		Student nullstudent=null;
		assertNull(nullstudent);
		assertNotNull(s);
		Student sameref=s; 
		assertSame(s,sameref);
		assertNotSame(s,new Student("somu",20,false));
		int a[]= {1,2,3};
		int b[]= {1,2,3};
		assertArrayEquals(a, b);
		assertThrows(ArithmeticException.class, ()->{int i=10/0;});
		}
}

class Student{
	String name;int age;boolean enrolled;

	public Student(String name, int age, boolean enrolled) {
		super();
		this.name = name;
		this.age = age;
		this.enrolled = enrolled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEnrolled() {
		return enrolled;
	}

	public void setEnrolled(boolean enrolled) {
		this.enrolled = enrolled;
	}
	
}

