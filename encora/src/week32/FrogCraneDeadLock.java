//package week32;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
///*
// * When their is a circular dependency between two synchronized
// * blocks, then dead lock occurs...
// */
//public class FrogCraneDeadLock {
//	public static void main(String[] args) {
//		ExecutorService es=Executors.newFixedThreadPool(2);
//		Crane russia=new Crane();
//		Frog ukraine=new Frog();
//		es.execute(()->{
//			russia.eat(ukraine);
//		});
//		es.execute(()->{
//			ukraine.escape(russia);
//		});		
//		es.shutdown();
//	}
//}
//
//class Crane{
//	synchronized public void eat(Frog frog) {
//		System.out.println();
//		frog.leave();
//		System.out.println("swaha.........");
//
//	}
//	synchronized public void leave() {//will be called by frog
//		
//	}
//}
//
//class Frog{
//	synchronized public void escape(Crane c) {
//		c.leave();
//	}
//	synchronized public void leave() {//will be called by crane
//		
//	}
//}

package week32;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class FrogCraneDeadLock{
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Crane russia = new Crane();
		Frog ukraine = new Frog();
		es.execute(()->{
			russia.eat(ukraine);
		});
		es.execute(()->{
			ukraine.escape(russia);
		});
		es.shutdown();
	}
}

class Crane{
	synchronized public void eat(Frog f) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		f.leave();
		System.out.println("khaliya....");
	}
	
	synchronized public void leave() {
		
	}
}

class Frog{
	synchronized public void escape(Crane c) {
		c.leave();
	}
	
	synchronized public void leave() {
		
	}
}