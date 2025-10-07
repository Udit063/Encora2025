package lifecycle;

public class LifeCycle{
	public static void main(String[] args) {
//		new LifeCycles();
//		LifeCycles.newInstance();
		LifeCycles.met();
	}
}

class LifeCycles {
	static int x = 10;
	static {
		System.out.println("static block called... " + x);
	}
	
	public LifeCycles() {
		System.out.println("cons called... ");
	}
	
	public static LifeCycles newInstance() {
		System.out.println("static factory method called");
		return new LifeCycles();
	}

	public static void met() {
		System.out.println("static method called... ");
	}
}
