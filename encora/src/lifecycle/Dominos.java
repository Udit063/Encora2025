package lifecycle;

public class Dominos {
	public static void main(String[] args) {
		Domino d = new ShobaDominos();
		d.sellPizza();
	}

}

// abstract classes --> we create template classes  --> special classes where standards protocols and everything are declared
abstract class Domino{  // can have constructor
	// abstract bcz ye koi bhi kr skta hai, if not abstract then sirf vhi kr skta hai
	public abstract void delivery();
	public abstract void collectMoney();
	
	// final are the one which can't be change by any, only parent have the right
	final public void makeDough() {
		System.out.println("make dough with secrecy....by dominos");
	}
	final public void addIngredients() {
		System.out.println("add ingredients with secrecy....by dominos");
	}
	
	final public void bakePizza() {
		System.out.println("bake pizza with secrecy....by dominos");
	}
	final public void makePizza() {
		makeDough();
		addIngredients();
		bakePizza();
	}
	final public void sellPizza() {
		collectMoney();
		makePizza();
		delivery();
	}
}

class ShobaDominos extends Domino{
	public void collectMoney() {
		System.out.println("Collect money as per Indian standard");
	}
	public void delivery() {
		System.out.println("Delivery pizza in bike");
	}
}
