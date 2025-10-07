//package mindGym;
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.Scanner;
////factory pattern
//public class MindGym8FactoryEx {
//	public static void main(String[] args) throws Exception{
//		Scanner scan=new Scanner(System.in);
//		System.out.println("Enter the factory class name...:");
//		String factoryclass=scan.next();
//		System.out.println("Enter the shop class name..:");
//		String shopclassname=scan.next();
//		
//		ShoeFactory factory=(ShoeFactory)Class.forName(factoryclass)
//				.getConstructor().newInstance();
//		ShoeShop shop=(ShoeShop)Class.forName(shopclassname)
//				.getConstructor().newInstance();
//		//Dependency injection
//		shop.setFactory(factory);
//		Customer customer=new Customer();
//		customer.setName("ramu kaka");
//		Shoe shoe=shop.sellShoe(customer);
//		System.out.println("Shoe....:"+shoe);
//	}
//}
//interface Manufacturer{
//	
//}
//interface ShoeManufacturer extends Manufacturer{
//	public Shoe makeShoe();
//}
//interface Seller{
//	
//}
//interface ShoeSeller extends Seller{
//	public Shoe sellShoe(Customer customer);
//}
//class Customer implements Comparable<Customer>, Serializable{
//	String name;
//	@Override
//	public int compareTo(Customer o) {
//		return this.name.compareTo(o.name);
//	}
//	public Customer() {
//		// TODO Auto-generated constructor stub
//	}
//	public Customer(String name) {
//		// TODO Auto-generated constructor stub
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	@Override
//	public String toString() {
//		return "Customer [name=" + name + "]";
//	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		return Objects.equals(name, other.name);
//	}	
//}
//abstract class ShoeFactory implements ShoeManufacturer{
//	
//}
//class BataShoeFactory extends ShoeFactory{
//	public BataShoeFactory() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public Shoe makeShoe() {
//		// TODO Auto-generated method stub
//		return LeatherShoe.newMultiInstance();
//	}
//}
//class LakhaniShoeFactory extends ShoeFactory{
//	public LakhaniShoeFactory() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public Shoe makeShoe() {
//		// TODO Auto-generated method stub
//		return SportsShoe.newMultiInstance();
//	}
//}
//abstract class ShoeShop implements ShoeSeller{
//	private ShoeFactory factory;
//	public ShoeShop() {
//		// TODO Auto-generated constructor stub
//	}
//	public ShoeShop(ShoeFactory factory) {
//		this.factory=factory;
//	}
//	public ShoeFactory getFactory() {
//		return factory;
//	}
//	public void setFactory(ShoeFactory factory) {
//		this.factory = factory;
//	}
//}
//class BabuShoeShop extends ShoeShop{
//	public BabuShoeShop() {
//		// TODO Auto-generated constructor stub
//	}
//	@Override
//	public Shoe sellShoe(Customer customer) {
//		// TODO Auto-generated method stub
//		return getFactory().makeShoe();
//	}
//}
//abstract class Shoe{
//	
//}
//class LeatherShoe extends Shoe implements Cloneable{
//	private LeatherShoe() {
//		System.out.println("leathershoe object created...");
//	}
//	private static LeatherShoe leatherShoe;
//	public LeatherShoe getClone() throws Exception{
//		return (LeatherShoe)super.clone();
//	}
//	synchronized public static LeatherShoe newSingleInstance() {
//		if(leatherShoe==null) {
//			leatherShoe=new LeatherShoe();
//		}
//		return leatherShoe;
//	}
//	synchronized public static LeatherShoe newMultiInstance() {
//		return new LeatherShoe();
//	}
//	
//}
//class SportsShoe extends Shoe implements Cloneable{
//	private SportsShoe() {
//		System.out.println("leathershoe object created...");
//	}
//	private static SportsShoe sportsShoe;
//	public SportsShoe getClone() throws Exception{
//		return (SportsShoe)super.clone();
//	}
//	synchronized public static SportsShoe newSingleInstance() {
//		if(sportsShoe==null) {
//			sportsShoe=new SportsShoe();
//		}
//		return sportsShoe;
//	}
//	synchronized public static SportsShoe newMultiInstance() {
//		return new SportsShoe();
//	}
//}


// Using annotations
package mindGym;

//Factory Pattern
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

//factory pattern

@Retention(RetentionPolicy.RUNTIME)
@interface Component{
	String value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface In{
	
}
class Container{
	private Container() {}
	public static ShoeShop getShop()throws Exception {
		Class c=ShoeFactory.class;
		Component com=(Component)c.getAnnotation(Component.class);
		String factoryname=null;
		if(com!=null) {
			factoryname=com.value();			
		}
		c=ShoeShop.class;
		com=(Component)c.getAnnotation(Component.class);
		String shopname=null;
		if(com!=null) {
			shopname=com.value();
		}
		ShoeFactory factory=(ShoeFactory)Class.forName(factoryname)
				.getConstructor().newInstance();
		ShoeShop shop=(ShoeShop)Class.forName(shopname)
				.getConstructor().newInstance();
		//Dependency injection
		c=shop.getClass().getSuperclass();
		Field f=c.getDeclaredField("factory");
		f.setAccessible(true);
		In in=f.getAnnotation(In.class);
		if(in!=null) {
			shop.setFactory(factory);	
		}
		
		return shop;
	}
}
public class MindGym8FactoryEx {
	public static void main(String[] args) throws Exception{
//		Scanner scan=new Scanner(System.in);
//		System.out.println("Enter the factory class name...:");
//		String factoryclass=scan.next();
//		System.out.println("Enter the shop class name..:");
//		String shopclassname=scan.next();
//		
//		ShoeFactory factory=(ShoeFactory)Class.forName(factoryclass)
//				.getConstructor().newInstance();
//		ShoeShop shop=(ShoeShop)Class.forName(shopclassname)
//				.getConstructor().newInstance();
//		//Dependency injection
//		shop.setFactory(factory);
		ShoeShop shop=Container.getShop();
		Customer customer=new Customer();
		customer.setName("ramu kaka");
		Shoe shoe=shop.sellShoe(customer);
		System.out.println("Shoe....:"+shoe);
		
//		Container.getShop();
	}
}
interface Manufacturer{
	
}
interface ShoeManufacturer extends Manufacturer{
	public Shoe makeShoe();
}

interface Seller{
	
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}

class Customer implements Comparable<Customer>, Serializable{
	String name;
	@Override
	public int compareTo(Customer o) {
		return this.name.compareTo(o.name);
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String name) {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(name, other.name);
	}	
}
@Component(value="mindGym.LakhaniShoeFactory")
abstract class ShoeFactory implements ShoeManufacturer{
	
}

class BataShoeFactory extends ShoeFactory{
	public BataShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return LeatherShoe.newMultiInstance();
	}
}
class LakhaniShoeFactory extends ShoeFactory{
	public LakhaniShoeFactory() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe makeShoe() {
		// TODO Auto-generated method stub
		return SportsShoe.newMultiInstance();
	}
}
@Component(value="mindGym.BabuShoeShop")
abstract class ShoeShop implements ShoeSeller{
	@In
	private ShoeFactory factory;
	public ShoeShop() {
		// TODO Auto-generated constructor stub
	}
	public ShoeShop(ShoeFactory factory) {
		this.factory=factory;
	}
	public ShoeFactory getFactory() {
		return factory;
	}

	public void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}
}

class BabuShoeShop extends ShoeShop{
	public BabuShoeShop() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Shoe sellShoe(Customer customer) {
		// TODO Auto-generated method stub
		return getFactory().makeShoe();
	}
}
abstract class Shoe{
	
}
class LeatherShoe extends Shoe implements Cloneable{
	private LeatherShoe() {
		System.out.println("leathershoe object created...");
	}
	private static LeatherShoe leatherShoe;
	public LeatherShoe getClone() throws Exception{
		return (LeatherShoe)super.clone();
	}
	synchronized public static LeatherShoe newSingleInstance() {
		if(leatherShoe==null) {
			leatherShoe=new LeatherShoe();
		}
		return leatherShoe;
	}
	synchronized public static LeatherShoe newMultiInstance() {
		return new LeatherShoe();
	}
	
}
class SportsShoe extends Shoe implements Cloneable{
	private SportsShoe() {
		System.out.println("leathershoe object created...");
	}
	private static SportsShoe sportsShoe;
	public SportsShoe getClone() throws Exception{
		return (SportsShoe)super.clone();
	}
	synchronized public static SportsShoe newSingleInstance() {
		if(sportsShoe==null) {
			sportsShoe=new SportsShoe();
		}
		return sportsShoe;
	}
	synchronized public static SportsShoe newMultiInstance() {
		return new SportsShoe();
	}
	
}

