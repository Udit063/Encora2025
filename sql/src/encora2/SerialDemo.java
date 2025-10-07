package encora2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Serializable is to used for storing passive data like passive memory (to store backup or something), the data which can be used later but not needed now

public class SerialDemo {
	public static void main(String[] args) throws Exception {
		Student ramu2024 = new Student("ramu", 560);
		System.out.println(ramu2024);
		FileOutputStream fos = new FileOutputStream("marks.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(ramu2024);
		System.out.println("Ramu re-writes the exam...");
		ramu2024.marks = 450;
		System.out.println(ramu2024);
		System.out.println("Ramu stick with the previous marks...");
		FileInputStream fis = new FileInputStream("marks.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ramu2024 = (Student)ois.readObject();
		System.out.println(ramu2024);
		
	}
}

// needs to be implemented to access the previous data and write in file otherwise will give error
class Student implements Serializable{
	String name;
	int marks;
	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return this.name + " : " + this.marks;
	}
} 
