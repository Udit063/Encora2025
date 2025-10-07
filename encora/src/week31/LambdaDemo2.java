package week31;

public class LambdaDemo2 {
	public static void main(String[] args) {
		new LambdaDemo2().new MyInterfaceImpl().met();
		class MyInterfaceImpl1 implements MyInterface{
			@Override
			public void met() {
				System.out.println("Rajiv gandhis way....");
			}
		}
		new MyInterfaceImpl1().met();
		//anonymous - sonia gandhis way
		MyInterface miImpl=new MyInterface() {
			@Override
			public void met() {
				System.out.println("sonia gandhis way....");
			}
		};
		miImpl.met();
		//Rahul gandhis ways - lambda
		miImpl=()->{
			System.out.println("rahul gandhis way....");
		};
		miImpl.met();
		//Method referencing - priyanka gandhis way
		miImpl=LambdaDemo2::vadhra;
		miImpl.met();
	}
	public static void vadhra() {
		System.out.println("vadhras way...");
	}
	
	class MyInterfaceImpl implements MyInterface{
		@Override
		public void met() {
			System.out.println("Indra gandhis way....");
		}
	}
}

//Gandhis way
class MyInterfaceImpl implements MyInterface{
	@Override
	public void met() {
		System.out.println("gandhis way called...");
	}
}
interface MyInterface{
	public void met();
}