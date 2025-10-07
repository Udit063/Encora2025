package encora;

public class HelloWorld {
	public static void main(String[] args) {
		HelloWorld obj = new HelloWorld();
		obj.net();
		Hello obj1 = new Hello();
		obj1.net();
		SubClass obj2 = new SubClass();
		obj2.net();
	}
	public int pub = 2;
	protected int pro = 4;
	private int pri = 6;
	int nomad = 8;
	
	void net() {
		System.out.println("pub" + pub);
		System.out.println("pro" + pro);
		System.out.println("pri" + pri);
		System.out.println("nomad" + nomad);
	}
}

class Hello{
	void net() {
		HelloWorld obj = new
				HelloWorld();
		System.out.println("pub1" +obj.pub);
		System.out.println("pro1" +obj.pro);
//		System.out.println("pri2" + pri)
	}
}

class SubClass extends HelloWorld{
	void net() {
		System.out.println("pub2" +pub);
		System.out.println("pro2"+pro);
		System.out.println("nomad2" +nomad);
//		System.out.println("pri2" + pri)
	}
}
