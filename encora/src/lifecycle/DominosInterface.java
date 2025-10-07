package lifecycle;

public class DominosInterface {
	public static void main(String[] args) {
		DominoInter d = new ShobaDominosInterface();
		d.sellPizza();
	}

}

// abstract classes --> we create template classes  --> special classes where standards protocols and everything are declared
interface DominoInter{
	// abstract bcz ye koi bhi kr skta hai, if not abstract then sirf vhi kr skta hai
	// abstract classes need to be overriden
	// in interface, by default it will be abstract class
	public void delivery();
	public void collectMoney();
	
	private void makeDough() {
		System.out.println("make dough with secrecy....by dominos");
	}
	private void addIngredients() {
		System.out.println("add ingredients with secrecy....by dominos");
	}
	
	private void bakePizza() {
		System.out.println("bake pizza with secrecy....by dominos");
	}
	private void makePizza() {
		makeDough();
		addIngredients();
		bakePizza();
	}
	public default void sellPizza() {
		collectMoney();
		makePizza();
		delivery();
	}
}

class ShobaDominosInterface implements DominoInter{
	//@Override
	public void collectMoney() {
		System.out.println("Collect money as per Indian standard");
	}
	//@Override
	public void delivery() {
		System.out.println("Delivery pizza in bike");
	}
}
