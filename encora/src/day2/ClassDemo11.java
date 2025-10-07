package day2;

public class ClassDemo11 {
	public static void main(String[] args) {
		ShoeFactory factory=new BataShoeFactory();
		ShoeShopp shop=new KakaShoeShop();
		//dependency injection
		shop.setFactory(factory);
		
		Shoe shoe=shop.sellShoe();
		
		System.out.println(shoe);
	}
}

abstract class Shoe{
	
}

class LeatherShoe extends Shoe{
	@Override
	public String toString() {
		return "This is a leather shoe...";
	}
}

class SportsShoe extends Shoe{
	@Override
	public String toString() {
		return "This is a sport shoe...";
	}
}

interface Manufacturer{
	public Shoe makeShoe();
}

abstract class ShoeFactory implements Manufacturer{}

class BataShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

interface Seller{
	public Shoe sellShoe();
}

abstract class ShoeShopp implements Seller{
	private ShoeFactory factory;
	public void setFactory(ShoeFactory factory) {
		this.factory=factory;
	}
	public ShoeFactory getFactory() {
		return this.factory;
	}
}
class KakaShoeShop extends ShoeShopp{
	@Override
	public Shoe sellShoe() {
		// TODO Auto-generated method stub
		return getFactory().makeShoe();
	}
}

