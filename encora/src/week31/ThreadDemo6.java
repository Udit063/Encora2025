package week31;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//class MyCallable implements Callable<String>{
//	@Override
//	public String call() throws Exception {
//		// TODO Auto-generated method stub
//		return "hello";
//	}
//}
public class ThreadDemo6 {
	public static void main(String[] args)throws Exception {
		
		ExecutorService es=Executors.newFixedThreadPool(3);
		//Future<String> f1=es.submit(new MyCallable());
		Future<String> f1=es.submit(()->{
			return "hello";
		});
		Future<String> f2=es.submit(()->{
			try {Thread.sleep(3000);}catch(Exception e) {}
			return "encora";
		});
		Future<String> f3=es.submit(()->{
			return "..world";
		});
		es.shutdown();
		
		System.out.println("main thread ready to serve...");
		
		String s1=f1.get();
		String s2=f2.get();
		String s3=f3.get();
		
		System.out.println(s1+":"+s2+":"+s3);
	}
}