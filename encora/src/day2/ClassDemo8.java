package day2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClassDemo8 {
	public static void main(String[] args) {
//		TrainingRoom t1 = new TrainingRoom();
//		TrainingRoom t2 = new TrainingRoom();
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{ // thread 1
			Thread.currentThread().setName("Salman Khan");
			synchronized(Toilet.class) {
				TrainingRoom.sulab.useToilet();
			}
		});
		es.execute(()->{
			Thread.currentThread().setName("Sharukh Khan");
			synchronized(Toilet.class) {				
				TrainingRoom.sulab.useToilet();
			}
		});
		es.shutdown();
	}
}

class TrainingRoom{
	// Every training room should have 1 projector but toilet can be only 1 which can be shared
	Projector sony = new Projector();
	
	// Added static to the toilet to declare it once, if not static then called no of times --> static called only 1 time and shared among --> static always run first in java
	static Toilet sulab = new Toilet();
}

class Projector{
	public Projector() {
		System.out.println("Projector object created...");
	}
}

class Toilet {
	public Toilet() {
		System.out.println("Toiler object created...");
	}
	
	// Can't make useToilet() as synchronized as because, it will lock the whole toilet instead of that particular one
	public void useToilet() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " using toilet");
		try {Thread.sleep(2000);}catch(Exception e) {}
		System.out.println(name + " is out of the toilet");
	}
}