package lifecycle;

public class Practice {
	public static void main(String[] args) {
		
		// static are also there to access the functions directly without creating any project
		Test obj = new Test();
		System.out.println("First: "+ obj);
		Test.Test3();
		obj.Test2();
		obj.Test3();
		obj.newInstance();
		Test.newInstance();
	}

}

class Test{
	public Test() {
		System.out.println("This is the first one");
	}
	
	public void Test2() {
		System.out.println("This is the second one");
	}
	
	public static Test newInstance() {
		System.out.println("This is the third one");
		return new Test();
	}
	
	public static void Test3() {
		System.out.println("This is the last one");
	}
}
