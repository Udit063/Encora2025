package lifecycle;

public class Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface A{ // it will not have any constructor as its a role, no object is created and roles can be changed (moh maya)
	
	public static float pi=3.14f;  // literals or constants
	// by default it will be abstract
	public void met();
	
	private void meet() {  // template private methods
		
	}
	
	public default void meeet() { // template global methods
		
	}
}

interface B extends A{ //no need to override the method as they both share the same interface
	
}

class X implements A{
	@Override
	public void met() {  // need to be override  --> those functions which can be used by other one and not have any restrictions
		
	}
}