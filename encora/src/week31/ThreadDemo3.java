package week31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo3 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(3);
		
		es.execute(()->{
			cutVegetables();		
		});
		es.execute(()->{
			boilRice();
		});
		es.execute(()->{
			addMutton();
			mixAllAndCook();
		});
		es.shutdown();
	}
	static void cutVegetables() {
		System.out.println("cutting vegetables...");
	}
	static void boilRice() {
		System.out.println("boiling rice...");
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("rice boiled....");
	}
	static void addMutton() {
		System.out.println("adding mutton...");
		try {Thread.sleep(5000);}catch(Exception e) {}
	}
	static void mixAllAndCook() {
		System.out.println("mix all and cook...");
	}
}

