package week32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClockRoomPractice {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ClockRooms cr = new ClockRooms();
		es.execute(()->{
			cr.setLuggage(new Luggages("Udit"));
			try {Thread.sleep(3000);} catch(Exception e) {}
			Luggages l1 = cr.getLuggage();
			System.out.println("Luggage milgya : " + l1);
			cr.setLuggage(new Luggages("Udit"));
			Luggages l2 = cr.getLuggage();
			System.out.println("Luggage mila : " + l2);
		}); 
		es.execute(()->{
			cr.setLuggage(new Luggages("Akshat"));
			Luggages l3 = cr.getLuggage();
			try {Thread.sleep(2000);} catch(Exception e) {}
			System.out.println("Luggage milgya : " + l3);
		});
		
	}
}

class ClockRooms{
	public static ThreadLocal<Luggages> tlocal = new ThreadLocal<Luggages>();
	public void setLuggage(Luggages luggage) {
		Luggages lg = tlocal.get();
		if(lg == null) {
			tlocal.set(luggage);
		} else {
			System.out.println("Luggage is already set...");
		}
	}
	
	public Luggages getLuggage() {
		Luggages lg = tlocal.get();
		if(lg==null) {
			System.out.println("No luggages found...");
			return null;
		} else {
			return lg;
		}
	}
}

class Luggages{
	String name;
	public Luggages(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Luggage ye hai : " + name;
	}
}