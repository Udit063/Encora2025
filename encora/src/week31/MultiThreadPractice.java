package week31;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MultiThreadPractice {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ReservationCounter rc = new ReservationCounter();
		es.execute(()->{
			Thread.currentThread().setName("Udit");
			synchronized(rc) {
				rc.bookTicket(1000);
				rc.giveChange();
			}
		});
		
		es.execute(()->{
			Thread.currentThread().setName("Akshat");
			synchronized(rc) {
				rc.bookTicket(500);
				rc.giveChange();
			}
		});
		
		es.shutdown();
	}
}

class ReserveCounters{
	int amount;
	public void BooksTicket(int amount) {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Ticket booked for "+name+", gave Rs."+amount);
		try {Thread.sleep(3000);} catch(Exception e) {};
	}
	
	public void givesChange() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		System.out.println("Change given to "+name+" Rs."+(amount - 150));
		try{Thread.sleep(5000);} catch(Exception e) {};
	}
}
