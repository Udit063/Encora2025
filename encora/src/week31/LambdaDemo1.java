package week31;

public class LambdaDemo1 {
	public static void main(String[] args) {
		// Implementation -> In lambda you don't have to declare the abstract method again as there is only one abstract method 
		MyInter m1=(int i)->{
			System.out.println("met called...." + i);
//			return "aa";
		};
		   
		MyInter2 m12=(x,y)->{return x+ ":" + y;};
		System.out.println(m12.met("encora",100));
		
		
		m1.met(1);
		myMet(m1);
		
//		Method Referencing
		m1=LambdaDemo1::add;
		m1.met(1);
		
		MyInter3 m14=()->{
			System.out.println("met called....123");
//			return "aa";
		};
		
		m14.met();
		
		m1=new LambdaDemo1()::add2;
		m1.met(1);
		
		m14 = LambdaDemo1::new;
		m14.met();
		
//		m1=new MyInter() {
//			@Override
//			public void met() {
//				
//			}
//		};
		
	}
	public static void myMet(MyInter m1) {
		m1.met(12);
	}
	
	public static void add(int i) {
		System.out.println("add method called...");
//		return "1";
	}
	
	public String add2(int i){
		System.out.println("add 222 method called...");
		return "2";
	}
	
}

// Rule - lambda works only with interfaces
// and the interface should have only one abstract method - FUNCTIONAL
@FunctionalInterface
interface MyInter{
	public void met(int i);
	public default void meet() {}
	private void meeet() {}
}

interface MyInter2{
	public String met(String x, int y);
}

interface MyInter3{
	public void met();
}

//package week3;
////jdk8 - 2014 - Lambda introduced
//public class LambdaDemo {
//	public LambdaDemo() {
//		System.out.println("cons called....");
//	}
//	public static void main(String[] args) {
//		//LAMBDA
//		MyInter mi=()->{
//			System.out.println("met called....");
//			return "aa";
//		};
//		
//		MyInter2 mi2=(x,y)->{return x+":"+y;};
//		
//		System.out.println(mi2.met("encora",100));
//		mi.met();
//		myMet(mi);
//		
//		//METHOD REFERENCING
//		mi=LambdaDemo::add;
//		mi.met();
//		
//		mi=new LambdaDemo()::add2;
//		mi.met();
//		
//		MyInter3 mi3=LambdaDemo::new;
//		mi3.met();
//		
//	}
//	public static String add() {
//		System.out.println("add method logic called...");
//		return "1";
//	}
//	public  String add2() {
//		System.out.println("add 2222 method logic called...");
//		return "1";
//	}
//	public static void myMet(MyInter mi) {
//		mi.met();
//	}
//	
//}
////rule - lambda works only with interfaces
////and the interface should have only one abstract method - FUNCTIONAL INTERFACE
//@FunctionalInterface
//interface MyInter{
//	public String met();
//	//public void meat();
//	public default void meet() {}
//	private void meeeeeet() {}
//}
//interface MyInter2{
//	public String met(String s,int i);
//}
//interface MyInter3{
//	public void met();
//}
//
