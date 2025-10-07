package apiClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ClassDemo {
	public static void main(String[] args) throws Exception{
		Politician ramu=new Politician();
		PoliceStation p1=new PoliceStation();
		p1.arrest(ramu);
	}
}
class Politician{
	public String publicName="good man";
	public void publicService(String s, int i) {
		System.out.println("noble services done.....");
	}
	
	private String secretName="gunda...";
	private void secretService(String s) {
		System.out.println("looting people....");
	}
}
class PoliceStation{
	public void arrest(Object suspect)throws Exception {
		Class c=suspect.getClass();
		Field f=c.getField("publicName");
		System.out.println(f.get(suspect));
		
		f=c.getDeclaredField("secretName");
		f.setAccessible(true);
		System.out.println(f.get(suspect));
		
		Method m=c.getMethod("publicService", String.class, int.class);
		m.invoke(suspect, "aa",90);
		
		m=c.getDeclaredMethod("secretService", String.class);
		m.setAccessible(true);
		m.invoke(suspect, "aaa");
	}
}