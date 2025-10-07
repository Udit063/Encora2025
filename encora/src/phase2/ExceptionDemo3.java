package phase2;

import java.util.Scanner;

public class ExceptionDemo3 {
	public static void main(String[] args) throws Exception{
		Child baby=new Child();
		Dog tiger=new Dog();
		Scanner scan=new Scanner(System.in);
		System.out.println("Type the Item class name..:");
		String itemclass=scan.next();
		Item item=(Item)Class.forName(itemclass).getConstructor().newInstance();
		baby.playWithDog(item, tiger);
	}
}

class Child{
	public void playWithDog(Item item,Dog dog) {
		System.out.println("Before Exception...");
		try {
			dog.play(item);
		}
		catch(DogExceptions dd) {
			//System.out.println("unknown dog exception...:"+dd);
			dd.visit();
		}
		System.out.println("After Exception...");
	}
}
class Dog{
	public void play(Item item)throws DogExceptions {
		item.execute();
	}
}

abstract class Item{
	public abstract void execute()throws DogExceptions;
}
class StoneItem extends Item{
	public StoneItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogBarkException("you throw I bark...");
	}
}
class StickItem extends Item{
	public StickItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogBiteException("You beat I bite.....");
	}
}
class BiscuitItem extends Item{
	public BiscuitItem() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute()throws DogExceptions {
		throw new DogHappyException("I love biscuits.......");
	}
}
abstract class DogExceptions extends Exception{
	public abstract void visit();
}
class DogBiteException extends DogExceptions{
	String msg;
	public DogBiteException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class DogBarkException extends DogExceptions{
	String msg;
	public DogBarkException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class DogHappyException extends DogExceptions{
	String msg;
	public DogHappyException(String msg) {
		this.msg=msg;
	}
	@Override
	public String toString() {
		return "Exception...:"+msg;
	}
	@Override
	public void visit() {
		new HelpLine911().help(this);
	}
}
class HelpLine911{
	public void help(DogBiteException dbe) {
		System.out.println("Take him to hospital...ambulance is on the way...");
	}
	public void help(DogBarkException dbr) {
		System.out.println("barking dogs seldom bite...dont worry....be calm...");
	}
	public void help(DogHappyException dbr) {
		System.out.println("dog is happy,....play and enjoy......");
	}
}

