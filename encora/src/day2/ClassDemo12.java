package day2;
public class ClassDemo12 {
	public static void main(String[] args) {
		IceCream myIceCream=new Vanila(new Nuts(new DryFruits(new Choclate(new Nuts(new Choclate())))));
		System.out.println("Cost..:"+myIceCream.cost());
	}
}
abstract class IceCream{
	public abstract int cost();
}
abstract class Cream extends IceCream{
	
}
abstract class Toppings extends IceCream{
	
}
class Vanila extends Cream{
	public Vanila() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Vanila(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(cream!=null) {
			return 10+cream.cost();
		}else {
			return 10;
		}
	}
}
class Strawberry extends Cream{
	public Strawberry() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Strawberry(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(cream!=null) {
			return 20+cream.cost();
		}
		else {
			return 20;
		}
	}
}
class Choclate extends Cream{
	public Choclate() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Choclate(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(cream!=null) {
			return 30+cream.cost();
		}
		else {
			return 30;
		}
	}
}
class Nuts extends Toppings{
	public Nuts() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public Nuts(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(cream!=null) {
			return 5+cream.cost();
		}
		else {
			return 5;
		}
	}
}
class DryFruits extends Toppings{
	public DryFruits() {
		// TODO Auto-generated constructor stub
	}
	IceCream cream;
	public DryFruits(IceCream cream) {
		this.cream=cream;
	}
	@Override
	public int cost() {
		// TODO Auto-generated method stub
		if(cream!=null) {
			return 20+cream.cost();
		}else {
			return 20;
		}
	}
}