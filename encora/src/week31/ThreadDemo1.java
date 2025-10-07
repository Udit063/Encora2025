package week31;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo1 {
	public static void main(String[] args)throws Exception {
		ExecutorService es=Executors.newFixedThreadPool(2);
		new Thread(new Thread1Work());
		es.execute(new Thread1Work());
		es.execute(new Thread2Work());
		System.out.println("hello 123");

		met();//first line
		es.shutdown();
	}
	static void met() throws Exception{
		System.out.println("hello ji");
		Thread.currentThread().sleep(3000);
		System.out.println("first line..");
	}
	static int met2()throws Exception {
		Thread.currentThread().sleep(3000);
		return 1;
	}
}

class Thread1Work implements Runnable{
	@Override
	public void run() {
		try{
			System.out.println("second line..:"+ThreadDemo1.met2());
		}catch(Exception e) {}
		}
}
class Thread2Work implements Runnable{
	@Override
	public void run() {
		System.out.println("third line....");
	}
}
