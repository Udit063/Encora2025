package week31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


// On creating deamon thread, it is not supported by Executor function, so we have to create our own thread. 
// Try not to use ThreadFactory, as its not a good practice, instead use lambda function

//class ThreadFactoryImpl implements ThreadFactory{
//	@Override
//	public Thread newThread(Runnable r) {
//		Thread t=new Thread(r);
//		t.setDaemon(true);
//		return t;
//	}
//}

public class DeamonThread2 {
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(1);
		
		
//		Not a good practice
		
//		ExecutorService es2=
//				Executors.newSingleThreadExecutor
//				(new ThreadFactoryImpl());

		ExecutorService es2=
				Executors.newSingleThreadExecutor
				((r)->{
					Thread t=new Thread(r);
					t.setDaemon(true);
					return t;
				});
		
		es2.execute(()->{	
			while(true) {
				System.out.println("daemon thread running...");
				try {Thread.sleep(500);}catch(Exception e) {}
			} 
		});
				
		
		es.execute(()->{
			while(true) {
				System.out.println("non deamon thread...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("main thread completed....");
		System.exit(0);
	}
}

