package week31;

/*
* DEMON THREAD:
* 1. A daemon thread continues its execution till the time main thread is running.
* 2. Once the main thread completes execution, the demon thread dies automatically. There's no need to kill it.
* 3. If non-daemon services are running even after the termination of the main thread, the daemon thread keeps,
* 	  running till all the non-demon services also terminate.
*/
public class DemonThread {
	public static void main(String[] args) {
		Thread t=new Thread(()->{
			while(true) {
				System.out.println("daemon thread running...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		t.setDaemon(true);
		t.start();
		
		Thread t2=new Thread(()->{
			while(true) {
				System.out.println("non deamon thread...");
				try {Thread.sleep(500);}catch(Exception e) {}
			}
		});
		t2.start();
		
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println("main thread completed....");
		System.exit(0);
	}
}