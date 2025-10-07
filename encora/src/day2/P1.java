package day2;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(()->{
			Thread.currentThread().setName("Salman");
			synchronized (Toilet.class) {
				TrainingRooms.sulab.useToilet();
			}
		});
		es.execute(()->{
			Thread.currentThread().setName("Sahrukh");
			synchronized (Toilet.class) {
				TrainingRooms.sulab.useToilet();
			}
		});
	}

}

class TrainingRooms{
	Projectors p = new Projectors();
	static Toilet sulab = new Toilet();
}

class Projectors{
	public Projectors(){
		System.out.println("Prjector object created...");
	}
}

class Toilets{
	public Toilets() {
		System.out.println("Toilet object created...");
	}
	public void UseToilet() {
		String name = Thread.currentThread().getName();
		System.out.println(name + " using toilet");
		try {Thread.sleep(2000);} catch(Exception e) {};
		System.out.println(name + "is out of toilet");
	}
}
