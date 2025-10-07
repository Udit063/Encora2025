package mindGym;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MindGym6 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			MySingleTon obj=MySingleTon.newInstance();
			System.out.println(obj);
			synchronized(MySingleTon2.class) {
				MySingleTon2.met();
			}
		});
		es.execute(()->{
			MySingleTon obj2=MySingleTon.newInstance();
			System.out.println(obj2);
			synchronized(MySingleTon2.class) {  // class lock --> as method locks failed when running a class --> in class lock, jb tk vo saare methods ko call na krle, tb tk vo lock khulta nhi hai 
				MySingleTon2.met();
			}
		});
		es.shutdown();
	}
}
//CREATIONAL PATTERNS
//Factory pattern, abstract factory pattern, factory method pattern
//builder pattern, prototype pattern, singleton pattern
//singleton
class MySingleTon{
	private MySingleTon() {
		//initialization logic i can keep here...
	}
	private static MySingleTon obj;
	synchronized public static MySingleTon newInstance() {
		if(obj==null) {
			obj=new MySingleTon();
		}
		return obj;
	}
}
class MySingleTon2{
	private MySingleTon2() {
		
	}
	static {
		//initialization logic is kept here...
	}
	synchronized public static void met() {}   // method lock --> if we add a method lock, then it will be locked till this method will be completed, and after that it will get opened.
	synchronized public static void met2() {}
	//outside - synchronized(MySingleTon2.class){}
}