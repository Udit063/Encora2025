package week32;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/*
 * Wait is used for infinitely make a method into infinitely waiting state, while sleep only make any method wait for a limited time period.
 * Notify is used to wake up the latest method from waiting while notify all is used to wake up all the methods in the waiting
 */

public class WaitNotify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(2);
		Gun bofor = new Gun();
		es.execute(()->{
			for(int i=0; i<5;i++) {
				bofor.FillGun();
			}
		});
		
		es.execute(()->{
			for(int i=0;i<5;i++) {
				bofor.ShootGun();
			}
		});
	}
}

class Gun{
	boolean flag = false;
	synchronized public void FillGun() {
		if(flag) {
			try {wait();} catch (Exception e) {};
		}
		System.out.println("Filling the gun...");
		flag = true;
		notify();
	}
	
	synchronized public void ShootGun() {
		if(!flag) {
			try {wait();} catch(Exception e) {};
		}
		System.out.println("Shooting the gun...");
		flag=false;
		notify();
	}
}