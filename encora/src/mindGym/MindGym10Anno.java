//package mindGym;
//
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.reflect.Field;
//
//public class MindGym10Anno {
//	public static void main(String[] args)throws Exception {
//		Bhai salmanbhai=new Bhai();
//		salmanbhai.buyRakhee(new Dukaandaar());
//	}
//}
//class Bhai{
//	public void buyRakhee(Dukaandaar nukkadshop)throws Exception {
//		Rakhee rakhee=nukkadshop.sellRakhee();
//		System.out.println(rakhee);
//	}
//}
//class Dukaandaar{
//	public Rakhee sellRakhee()throws Exception {
//		Rakhee rakhee=new Rakhee();
//		Class c=rakhee.getClass();
//		Field f=c.getDeclaredField("diamonds");
//		f.setAccessible(true);
//		Inject inject=(Inject)f.getAnnotation(Inject.class);
//		if(inject!=null) {
//			String value=inject.moneyValue();
//			rakhee.diamonds="diamonds set with value..:"+value;
//		}
//		f=c.getDeclaredField("gold");
//		f.setAccessible(true);
//		inject=(Inject)f.getAnnotation(Inject.class);
//		if(inject!=null) {
//			String value=inject.moneyValue();
//			rakhee.gold="gold set with value..:"+value;
//		}
//		f=c.getDeclaredField("moti");
//		f.setAccessible(true);
//		inject=(Inject)f.getAnnotation(Inject.class);
//		if(inject!=null) {
//			String value=inject.moneyValue();
//			rakhee.moti="moti set with value..:"+value;
//		}
//		return rakhee;
//	}
//}
//@Retention(RetentionPolicy.RUNTIME)
//@interface Inject{
//	String moneyValue();
//}
//class Rakhee{
//	@Inject(moneyValue="million dollor")
//	String diamonds;
//	
//	String moti;
//	
//	@Inject(moneyValue="2 million")
//	String gold;
//	public String toString() {
//		return diamonds+":"+moti+":"+gold;
//	}
//}


package mindGym;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class MindGym10Anno{
	public static void main(String[] args) throws Exception {
		Bhai bh = new Bhai();
		bh.buyRakhee(new DukaanDaar());
	}
}

class Bhai{
	public void buyRakhee(DukaanDaar ramu) throws Exception {
		Rakhee rakhee = ramu.sellRakhee();
		System.out.println(rakhee);
	}
}

class DukaanDaar{
	public DukaanDaar() {
		System.out.println("Dukaandaar cons called...");
	}
	public Rakhee sellRakhee() throws Exception {
		Rakhee rakhee = new Rakhee();
		Class c = rakhee.getClass();
		Field f = c.getDeclaredField("diamonds");
		f.setAccessible(true);
		Inject inject = (Inject)f.getAnnotation(Inject.class);
		if(inject!=null) {
			String value = inject.moneyValue();
			rakhee.diamonds = "diamonds set with value: " + value;
		}
		
		Field f1 = c.getDeclaredField("moti");
		f1.setAccessible(true);
		Inject inject1 = (Inject)f1.getAnnotation(Inject.class);
		if(inject1 != null) {
			String value = inject1.moneyValue();
			rakhee.moti = "value set for moti: "+value;
		}
		
		Field f2 = c.getDeclaredField("gold");
		f2.setAccessible(true);
		Inject inject2 = (Inject)f2.getAnnotation(Inject.class);
		if(inject2 != null) {
			String value = inject2.moneyValue();
			rakhee.gold = "gold set for value: "+value;			
		}
		return rakhee;
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface Inject{
	String moneyValue();
}

class Rakhee{
	@Inject(moneyValue="millio dollar")
	String diamonds;
	
	String moti;
	
	@Inject(moneyValue="2 million dollar")
	String gold;
	
	public String toString() {
		return "Diamond: " + diamonds + " Moti: "+ moti + " Gold: "+ gold;
	}
}