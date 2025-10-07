//package mindGym;
////Decorator Pattern
//public class MindGym9_Decorator {
//	public static void main(String[] args) {
//		Thaali thaali=new Rice(new Daal());
//		System.out.println("Only Rice with Daal..:"+thaali.cost());
//		
//		thaali=new Rice(new Daal(new Chicken()));
//		System.out.println("Rice with daal and chicken..:"+thaali.cost());
//	}
//}
//abstract class Thaali{
//	public abstract int cost();
//}
//abstract class VegItems extends Thaali{
//	
//}
//abstract class NonVegItems extends Thaali{
//	
//}
//class Rice extends VegItems{
//	Thaali thaali;
//	public Rice() {
//		// TODO Auto-generated constructor stub
//	}
//	public Rice(Thaali thaali) {
//		this.thaali=thaali;
//	}
//	@Override
//	public int cost() {
//		// TODO Auto-generated method stub
//		if(thaali!=null) {
//			return 10+thaali.cost();
//		}
//		else {
//			return 10;
//		}
//	}
//}
//class Daal extends VegItems{
//	Thaali thaali;
//	public Daal() {
//		// TODO Auto-generated constructor stub
//	}
//	public Daal(Thaali thaali) {
//		this.thaali=thaali;
//	}
//	@Override
//	public int cost() {
//		// TODO Auto-generated method stub
//		if(thaali!=null) {
//			return 5+thaali.cost();
//		}
//		else {
//			return 5;
//		}
//	}
//}
//class Chicken extends NonVegItems{
//	Thaali thaali;
//	public Chicken() {
//		// TODO Auto-generated constructor stub
//	}
//	public Chicken(Thaali thaali) {
//		this.thaali=thaali;
//	}
//	@Override
//	public int cost() {
//		// TODO Auto-generated method stub
//		if(thaali!=null) {
//			return 10+thaali.cost();
//		}
//		else {
//			return 10;
//		}
//	}
//}


package mindGym;

public class MindGym9_Decorator{
	public static void main(String[] args) {
		Thali th = new Rice(new Chicken());
		System.out.println(th.cost());
	}
}

abstract class Thali{
	public abstract int cost();
}

abstract class VegItems extends Thali{}
abstract class NonVegItems extends Thali{}

class Rice extends VegItems{
	Thali thali;
	public Rice() {
		
	}
	public Rice(Thali thali) {
		this.thali=thali;
	}
	public int cost() {
		if(thali != null) {
			return 10 + thali.cost();
		}
		else {
			return 10;
		}
	}
}

class Daal extends VegItems{
	Thali thali;
	public Daal() {
		
	}
	public Daal(Thali thali) {
		this.thali=thali;
	}
	public int cost() {
		if(thali!=null) {
			return 15 + thali.cost();
		}
		else {
			return 15;
		}
	}
}

class Chicken extends NonVegItems{
	Thali thali;
	public Chicken() {
		
	}
	public Chicken (Thali thali) {
		this.thali=thali;
	}
	public int cost() {
		if(thali!=null) {
			return 30 + thali.cost();
		} else {
			return 30;
		}
	}
}