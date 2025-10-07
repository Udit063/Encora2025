package week31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//MULTI-THREADING
public class OneObjectManyThreads {
 public static void main(String[] args) {
  ExecutorService es = Executors.newFixedThreadPool(2);
  ReservationCounter rc = new ReservationCounter();
  es.execute(()->{
   Thread.currentThread().setName("Archit");
   
   //Instead of putting synchronized before every function, 
   //we can directly use synchronized during execution of the threads
   //This is called PESSIMISTIC LOCKING
   synchronized (rc) {
    rc.bookTicket(500);
    rc.giveChange();
   }
  });
  es.execute(()->{
   Thread.currentThread().setName("Ayush");
   synchronized (rc) {
    rc.bookTicket(200);
    rc.giveChange();
   }
  });
  es.shutdown();
 }
}
/*
 * OPTIMISTIC VS PESSIMISTIC LOCKING:
 * 1. In Optimistic Locking, if one thread enters an object and as soon as it completes its execution in 
 *    any one of the methods in that object, the locks opens for all the threads and other threads are also
 *    able to access the object at the same time. This is useful in some scenarios but can cause trouble in others.
 * 
 * 2. However, in Pessimistic Locking, the entire object is locked if one thread has entered the object. This 
 *    ensures that only one thread access the object at a time. The lock will not be opened till all the 
 *    transactions of the thread are completed with that object.
 */

class ReservationCounter{
 int amount;
 public void bookTicket(int amount) {
  this.amount = amount;
  Thread thread = Thread.currentThread();
  String name = thread.getName();
  System.out.println("Ticket booked for "+name+", gave Rs."+amount);
  try{Thread.sleep(3000);}catch(Exception e) {}
 } 
 
 //Putting synchronized in front of individual methods is called OPTIMISTIC LOCKING
 synchronized public void giveChange() {
  Thread thread = Thread.currentThread();
  String name = thread.getName();
  System.out.println("Change given to "+name+" Rs."+(amount - 150));
  try{Thread.sleep(1000);}catch(Exception e) {}
 }
}

//public class OneObjectManyThreads {
//	public static void main(String[] args) {
//		ExecutorService es=Executors.newFixedThreadPool(2);
//		ReservationCounter central=new ReservationCounter();
//		
//		es.execute(()->{
//			Thread.currentThread().setName("sharukh khan");
//			synchronized(central) {
//				central.bookTicket(500);
//				central.giveChange();
//			}
//			
//			//central.water();
//		});
//		es.execute(()->{
//			Thread.currentThread().setName("salman khan");
//			synchronized(central) {
//			central.bookTicket(1000);
//			central.giveChange();
//			}
//		});
//		
//		es.shutdown();
//	}
//}
//class ReservationCounter{
//	int amt;
//	 public void bookTicket(int amt) {
//		this.amt=amt;
//		Thread t=Thread.currentThread();
//		String name=t.getName();
//		try {Thread.sleep(1000);}catch(Exception e) {}
//		System.out.println("Ticket booked by..:"+name+" for"+this.amt);
//		System.out.println(name+" booking ticket for ..:"+this.amt);
//		try {Thread.sleep(5000);}catch(Exception e) {}
//	}
//	 public void giveChange() {
//		Thread t=Thread.currentThread();
//		String name=t.getName();
//		System.out.println("Change given to...:"+name+":"+(amt-100));
//		System.out.println(name+" is given the change..:"+(amt-100));
//	}
//	 public void water() {
//		System.out.println("water called...:");
//	}
//}
