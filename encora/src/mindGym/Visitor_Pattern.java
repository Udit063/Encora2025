//package mindGym;
//
//import java.util.Scanner;
//
////VISITOR PATTERN
//public class Visitor_Pattern {
//	public static void main(String[] args) throws Exception{
//		Scanner scan = new Scanner(System.in);
//		Child baby = new Child();
//		Dog tiger = new Dog();
//		
//		System.out.println("Type the Item class name: ");
//		String itemclass = scan.next();
//		
//		Item item = (Item)Class.forName(itemclass).getConstructor().newInstance();
//		baby.playWithDog(item, tiger);
//	}
//}
//
//class Child{
//	public void playWithDog(Item item,Dog dog) {
//		try {
//			dog.play(item);
//		}
//		catch(DogExceptions dd) {
//			//System.out.println("unknown dog exception...:"+dd);
//			dd.visit();
//		}
//	}
//}
//class Dog{
//	public void play(Item item)throws DogExceptions {
//		item.execute();
//	}
//}
//
//abstract class Item{
//	public abstract void execute()throws DogExceptions;
//}
//class StoneItem extends Item{
//	public StoneItem() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public void execute()throws DogExceptions {
//		throw new DogBarkException("You throw, I bark!");
//	}
//}
//class StickItem extends Item{
//	public StickItem() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public void execute()throws DogExceptions {
//		throw new DogBiteException("You beat, I bite!");
//	}
//}
//class BiscuitItem extends Item{
//	public BiscuitItem() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public void execute()throws DogExceptions {
//		throw new DogHappyException("I love biscuits!");
//	}
//}
//abstract class DogExceptions extends Exception{
//	public abstract void visit();
//}
//class DogBiteException extends DogExceptions{
//	String msg;
//	public DogBiteException(String msg) {
//		this.msg = msg;
//	}
//	@Override
//	public String toString() {
//		return "Exception: "+msg;
//	}
//	@Override
//	public void visit() {
//		new HelpLine911().help(this);
//	}
//}
//class DogBarkException extends DogExceptions{
//	String msg;
//	public DogBarkException(String msg) {
//		this.msg=msg;
//	}
//	@Override
//	public String toString() {
//		return "Exception: "+msg;
//	}
//	@Override
//	public void visit() {
//		new HelpLine911().help(this);
//	}
//}
//class DogHappyException extends DogExceptions{
//	String msg;
//	public DogHappyException(String msg) {
//		this.msg=msg;
//	}
//	@Override
//	public String toString() {
//		return "Exception: "+msg;
//	}
//	@Override
//	public void visit() {
//		new HelpLine911().help(this);
//	}
//}
//class HelpLine911{
//	public void help(DogBiteException dbe) {
//		System.out.println("Take him to hospital. Ambulance is on the way.");
//	}
//	public void help(DogBarkException dbr) {
//		System.out.println("Barking dog seldom bites, dont worry, be calm.");
//	}
//	public void help(DogHappyException dbr) {
//		System.out.println("Dog is happy, play and enjoy.");
//	}
//}


package mindGym;

public class Visitor_Pattern{
	public static void main(String[] args) {
		Shape s = new Square();
		Visitor v = new DrawVisitor();
		s.accept(v);
	}
}

interface Visitor{
	void visit(Circle c);
	void visit(Square s);
}

interface Shape{
	void accept(Visitor v);
}

class Circle implements Shape{
	public void accept(Visitor v) {
		v.visit(this);
	}
}

class Square implements Shape{
	public void accept(Visitor v) {
		v.visit(this);
	}
}

class DrawVisitor implements Visitor{
	public void visit(Circle c) {
		System.out.println("Drawing circle");
	}
	public void visit(Square s) {
		System.out.println("Drawing square");
	}
}