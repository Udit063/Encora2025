//package mindGym;
//public class MindGym3 {
////CONSTRUCTOR, METHOD OVERLOADING, METHOD OVERRIDING, THIS, SUPER, FINAL, STATIC
//	public static void main(String[] args) {
//		Hall dhall=new DiningHall();
//		Hall mhall=new MarriageHall();
//		Society obj=new Society();
//		obj.useHall(dhall,"for dining..");
//		obj.useHall(mhall," for marriage..");
//		//obj is getting reused for two kinds of halls - OBJECT REUSABILITY
//	}
//}
//class Society{
//	void useHall(Hall hall,String purpose) {
//		System.out.println("Purpose..:"+purpose);
//		hall.useChairs();
//		System.out.println(hall.x);
//	}
//}
//abstract class Hall{// by declaring abstract- one cannot create object of this class
//	int x=100;//no overriding for variables
//	public Hall(String name) {
//		System.out.println("hall cons called....");
//	}
//	public static void useChairs2() {}//static methods are not overridden
//	public  void useChairs() {//non abstract methods should be declared final
//		System.out.println("chairs are common for all the purposes...");
//		
//	}
//	//an abstract class can have abstract methods
//	protected  abstract void decoration();
//}
////INHERITANCE - KIND OF RELATIONSHIP
//class DiningHall extends Hall{
//	int x=999;
//	public DiningHall() {
//		super("aaaaa");
//		System.out.println("dining hall cons called...");		
//	}
//	
//	public void useChairs() {
//		super.useChairs();
//		System.out.println("customer using his own chairs....");
//	}
//	@Override
//	public void decoration() {
//		System.out.println("dining decoration....");
//	}
//}
//class MarriageHall extends Hall{
//	public MarriageHall() {
//		super("aa");
//		System.out.println("marriage hall cons called..");
//	}
//	@Override
//	public void decoration() {
//		System.out.println("marriage decoration..");
//		
//	}
//}
////its a must that all classes should belong to a hierarchy
///*
//Advantages of creating a hierarchy
//1. code re-usability
//2. Object re-usability
//3. create part whole hierarchy
//4. do composition
//5. eliminate if-else-if conditions
//6. Polymorphic query
//*/
//
//
//
//
//

package mindGym;

public class MindGym3{
	public static void main(String[] args) {
		DiningHall dh = new DiningHall();
		MarriageHall hh = new MarriageHall();
		hh.useChairs();
		Society s1 = new Society();
		s1.useHall(dh, "dining");
		s1.useHall(hh, "marriage");
	}
}

class Society{
	public void useHall(Hall hall, String Purpose) {
		System.out.println("Purpose :" + Purpose);
		hall.useChairs();
		System.out.println(hall.x);
	}
}

abstract class Hall{
	int x=100;
	public Hall(String name) {
		System.out.println("Hall cons called...");
	}
	
	abstract public void useChairs();
}

class DiningHall extends Hall{
	public DiningHall() {
		super("aaa");
		System.out.println("dining cons called...");
	}
	public void useChairs() {
		System.out.println("dining ki chairs...");
	}
}

class MarriageHall extends Hall{
	public MarriageHall() {
		super("aaa");
		System.out.println("marriage cons called...");
	}
	public void useChairs() {
		System.out.println("marriage ki chairs bhi to same hogi...");
	}	
}