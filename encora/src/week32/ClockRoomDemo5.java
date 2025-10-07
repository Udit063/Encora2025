//package week32;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ClockRoomDemo5 {
//	public static void main(String[] args) {
//		ExecutorService es=Executors.newFixedThreadPool(2);
//		ClockRoom cr=new ClockRoom();
//		es.execute(()->{
//			cr.setLuggage(new Luggage("salman khan"));
//			try {Thread.sleep(5000);}catch(Exception e) {}
//			Luggage lug=cr.getLuggage();
//			System.out.println("lug:" +lug);
//			cr.getLuggage();
//			cr.setLuggage(new Luggage("salman khan"));
//			System.out.println(cr.getLuggage());
//		});
//		es.execute(()->{
//			cr.setLuggage(new Luggage("sharukh khan"));
//			try {Thread.sleep(1000);}catch(Exception e) {}
//			Luggage lug=cr.getLuggage();
//			System.out.println(lug);
//		});
//		es.shutdown();
//	}
//}
//class ClockRoom{
//	private static ThreadLocal<Luggage> tlocal=new ThreadLocal<Luggage>();
//	public void setLuggage(Luggage luggage) {
//		Luggage lg=tlocal.get();
//		if(lg==null) {
//			tlocal.set(luggage);
//		}
//		else {
//			System.out.println("already luggage set...");
//		}
//	}
//	public Luggage getLuggage() {
//		Luggage lg=tlocal.get();
//		if(lg==null) {
//			System.out.println("no luggage for this thread...");
//			return null;
//		}
//		else {
//			tlocal.remove();
//			return lg;
//		}
//	}
//}
//
//class Luggage{
//	String name;
//	public Luggage(String name) {
//		this.name=name;
//	}
//	@Override
//	public String toString() {
//		return "Luggage..:"+name;
//	}
//}
//


package week32;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClockRoomDemo5 {
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(2);
		ClockRoom cr = new ClockRoom();
		es.execute(()->{
			cr.setLuggage(new Luggage("Sharukh"));
			try {Thread.sleep(3000);} catch(Exception e) {}
			Luggage lg1 = cr.getLuggage();
			System.out.println("Luggage hai : " + lg1);
			cr.setLuggage(new Luggage("Sharukh"));
			Luggage lg2 = cr.getLuggage();
			System.out.println("Luggage ye vala hai : " + lg2);
			System.out.println("ye luggae: "+ cr.getLuggage());
		});
		
		es.execute(()->{
			cr.setLuggage(new Luggage("Salman"));
			try {Thread.sleep(2000);} catch (Exception e) {}
			Luggage lg1 = cr.getLuggage();
			System.out.println("Ye luggage hai: "+ lg1);
		});
	}
}

/*
 * THREAD LOCAL is in-built class in java. It is used to remember the objects that are stored within a particular thread.
 * It does this by mapping the id of the thread to that of the object. It is a mapped structure.
 */

class ClockRoom{
	private static ThreadLocal<Luggage> tlocal = new ThreadLocal<Luggage>();
	public void setLuggage(Luggage luggage) {
		Luggage lg = tlocal.get();
		if(lg == null) {
			tlocal.set(luggage);
		} else {
			System.out.println("Luggage is already set...");
		}
	}
	
	public Luggage getLuggage() {
		Luggage lg = tlocal.get();
		if(lg==null) {
			System.out.println("No luggae found");
			return null;
		} else {
//			tlocal.remove();
			return lg;
		}
	}
}

class Luggage{
	String name;
	public Luggage(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "luggage : " + name;
	}
}
