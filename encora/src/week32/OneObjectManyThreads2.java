package week32;
// pessimistic lock

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class OneObjectManyThreads2 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Theatre screen1 = new Theatre();
		Theatre screen2 = new Theatre();
		es.execute(()->{
			synchronized(Toilet.class) {
				Thread.currentThread().setName("Sharukh");
				screen1.sulabh.useToilet();
			}
		});
		
		es.execute(()->{
			synchronized(Toilet.class) {
				Thread.currentThread().setName("Salman");
				screen2.sulabh.useToilet();
			}
		});
		
		es.shutdown();
	}
}

class Theatre{
	public static Toilet sulabh = new Toilet();
}

class Toilet{
	public Toilet() {
		System.out.println("Toilet object created...");
	}
	public void useToilet() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println(name + " is using the toilet.");
		try {Thread.sleep(3000);} catch(Exception e) {};
		System.out.println(name + " is out of the toilet.");
	}
}