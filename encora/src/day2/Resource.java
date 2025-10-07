package day2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Resource {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		MyResource obj = MyResource.newInstance();
//		MyResource obj2 = MyResource.newInstance();
//		
//		System.out.println(obj);
//		System.out.println(obj);
//	}
	
//	--------- Threads (Not imp for now) ------------
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{//thread 1
			MyResource obj=MyResource.newInstance();
			System.out.println(obj);
		});
		es.execute(()->{//thread 2
			MyResource obj2=MyResource.newInstance();
			System.out.println(obj2);
		});
		es.shutdown();		
	}

}

//Singleton  --> only one object
class MyResource{
	private MyResource() {
		
	}
	private static MyResource obj;
	
//	Rules of static are:-
//	1. Static variable are initialized by JVM
//	2. Static variables and methods are directly accessed by class name
//	3. Static methods can only access static members
//	4. Static block is called when the static method invoked (only once)
	
	synchronized public static MyResource newInstance() {  // only one at a time --> prime minister car --> as using if and else will create a traffic (choraha)
// 		synchronized -> first 1 thread will enter the method, till then next thread wait (called semaphore)
//		otherwise, we will have to face double-dip issue, i.e., both threads are in at once
		System.out.println("first: " + obj);
		if(obj==null) {
			obj=new MyResource();
			System.out.println("second: " + obj);
		}
		return obj;
	}
}
