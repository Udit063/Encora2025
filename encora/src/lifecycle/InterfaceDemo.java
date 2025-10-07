package lifecycle;

public class InterfaceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(MyInter.pi);
	}

}

interface MyInter{
	public final static float pi=1.34f;
	public void met();
	private void meet() {
		
	}
	public default void meeeet() {
		
	}
}

interface MyInter2 extends MyInter{
	
}

interface MyInter3{
	
}

class Mine implements MyInter2, MyInter3{
	@Override
	public void met() {
		
	}
}
