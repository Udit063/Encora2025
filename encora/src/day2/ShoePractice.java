package day2;

public class ShoePractice {
	public static void main(String[] args) {
		ShoesFactory fc=new BataShoesFactory();
		ShoesShops sp = new KakaShop();
		
		sp.setFactories(fc);
		Shoes shoe = sp.sellShoes();
		System.out.println(shoe);
		System.out.println(sp.getFactories());
	}
}

abstract class Shoes{}

class SportsShoes extends Shoes{
	@Override
	public String toString(){
		return "This is sports shoes...";
	}
}

class LeatherShoes extends Shoes{
	@Override
	public String toString() {
		return "This is leather shoes...";
	}
}

interface Manufacturers{
	public Shoes makeShoes();
}

abstract class ShoesFactory implements Manufacturers{}

class BataShoesFactory extends ShoesFactory{
	public Shoes makeShoes() {
		return new SportsShoes();
	}
}

class LakhaniShoesFactory extends ShoesFactory{
	public Shoes makeShoes() {
		return new LeatherShoes();
	}
}

interface Sellers{
	public Shoes sellShoes();
}

abstract class ShoesShops implements Sellers{
	private ShoesFactory factories;
	public void setFactories(ShoesFactory factories) {
		this.factories=factories;
	}
	public ShoesFactory getFactories() {
		return this.factories;
	}
}

class KakaShop extends ShoesShops{
	public Shoes sellShoes() {
		return getFactories().makeShoes();
	}
}