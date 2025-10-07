package mindGym;
// Inheritance, overriding, overloading, constructor, this, final, static
public class MindGym3Rev {
	public static void main(String[] args) {
		Item item=new StoneItem();
		Child baby=new Child();
		baby.play(item);
		StoneItem.met();
	}
}
class Child{
	//java automatically picks up the method based on the data passed
	//virtual method invocation
	//problem with this is, you code is open for modification
	//Rules for overloading - name of the method should be same, return type can change
	//parameter have to be necessarily different
//	public void play(StoneItem si) {
//		
//	}
//	public int play(StickItem st) {
//		return 1;
//	}
	//to solve this we have inheritance
	public void play(Item item) {
		item.execute();
	}
}
abstract class Item{
	
	public Item(String s) {
		System.out.println("over loaded item class cons called....:"+s);
	}
	abstract public void execute() ;//the signature has to be same when overriding a method
	//only the access specifier can be changed, that too you cannot minimize the visibility
	//Rules of overriding
	// you cannot override a static method, you cannot override variables, you cannot override constructors
	public static void met() {
		System.out.println("met of item called...-static");
	}
}
class StoneItem extends Item{
	public StoneItem() {
		super("aaa");//this should be the first line
		System.out.println("stone class constructor called....");
	}
	public StoneItem(String s,int i) {
		super("aa");
	}
	public static void met() {
		System.out.println("met of stone item called...-static");
	}
	@Override
	public void execute() {		
		System.out.println("stone item class execute method called...");
		//super.execute();
	}
}
class StickItem extends Item{
	public StickItem() {
		super("aa");
		System.out.println("stick class constructor called...");
	}
	@Override
	public void execute() {
		System.out.println("stick item class execute method called...");
		
	}
}