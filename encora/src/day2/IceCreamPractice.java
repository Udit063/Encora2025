package day2;
public class IceCreamPractice {
	public static void main(String[] args) {
		IceCreams ice = new Vanillas(new NewNutss(new StrawBerries()));
		System.out.println(ice.cost());
	}
}

abstract class IceCreams{
	public abstract int cost();
}

abstract class Creams extends IceCreams{}
abstract class Topping extends IceCreams{}

class Vanillas extends Creams{
	IceCreams cream;
	public Vanillas(IceCreams creams) {
		this.cream=creams;
	}
	public Vanillas() {
	}
	
	public int cost() {
		if(cream !=  null) {
			return 10 + cream.cost();
		} else {
			return 10;
		}
	}
}

class StrawBerries extends Creams{
	IceCreams cream;
	public StrawBerries() {
	}
	public StrawBerries(IceCreams creams) {
		this.cream=creams;
	}
	public int cost() {
		if(cream!=null) {
			return 5+cream.cost();
		} else {
			return 5;
		}
	}
}

class NewNutss extends Topping{
	IceCreams cream;
	public NewNutss() {
		
	}
	public NewNutss(IceCreams creams) {
		this.cream = creams;
	}
	public int cost() {
		if(cream!=null) {
			return 2+cream.cost();
		} else {
			return 2;
		}
	}
}
