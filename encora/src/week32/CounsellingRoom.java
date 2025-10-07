package week32;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/*
 * package week3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OneObjectManyThreads3 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(5);
		es.execute(()->{
				Thread.currentThread().setName("red");
				Colleges.admission.table1();
				Colleges.admission.table2();
				Colleges.admission.table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("blue");
			Colleges.admission.table1();
			Colleges.admission.table2();
			Colleges.admission.table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("green");
			Colleges.admission.water();
			Colleges.admission.table1();
			Colleges.admission.table2();
			Colleges.admission.table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("yellow");
			Colleges.admission.table1();
			Colleges.admission.table2();
			Colleges.admission.table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("brown");
			Colleges.admission.table1();
			Colleges.admission.table2();
			Colleges.admission.table3();
		});
		es.shutdown();
	}
}
class Colleges{
	static CounsellingHall admission=new CounsellingHall();
}
class CounsellingHall{
	synchronized public void table1() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" is in table 1");
		try {Thread.sleep(3000);}catch(Exception e) {}
		System.out.println(name+" is out of table 1");
	}
	synchronized public void table2() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" is in table 2");
		try {Thread.sleep(1000);}catch(Exception e) {}
		System.out.println(name+" is out of table 2");
	}
	synchronized public void table3(){
		String name=Thread.currentThread().getName();
		System.out.println(name+" is in table 3");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println(name+" is out of table 3");
	}
	public void water() {
		String name=Thread.currentThread().getName();
		System.out.println(name+" is drinking water");
		try {Thread.sleep(500);}catch(Exception e) {}
		System.out.println(name+" is out of drinking water");
	}
}


 */

public class CounsellingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(3);
		CounsellingTable person1 = new CounsellingTable();
		CounsellingTable person2 = new CounsellingTable();
		CounsellingTable person3 = new CounsellingTable();
		CounsellingTable thirstyPerson = new CounsellingTable();
		
		es.execute(()->{
			Thread.currentThread().setName("Udit");
			person1.Table1();
			person2.Table2();
			person3.Table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("Rohan");
			person1.Table1();
			person2.Table2();
			person3.Table3();
		});
		es.execute(()->{
			Thread.currentThread().setName("Rahul");
			thirstyPerson.drinkWater();
		});
		es.execute(()->{
			Thread.currentThread().setName("Naman");
			person1.Table1();
			person2.Table2();
			person3.Table3();
		});
		es.shutdown();
	}
}

class CounsellingTable{
	public void drinkWater() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + " Drinking water");
		try {Thread.sleep(3000);}catch(Exception e) {}
		System.out.println(name + " drank water");
	}

synchronized public void Table1(){
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Table 1 counselling is doing for : " + name);
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("Table 1 counselling is done for : " + name);
	
}

synchronized public void Table2(){	
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Table 2 counselling is doing for : " + name);
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("Table 2 counselling is done for : " + name);
	
}

synchronized public void Table3(){	
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Table 3 counselling is doing for : " + name);
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("Table 3 counselling is done for : " + name);
	
}
}