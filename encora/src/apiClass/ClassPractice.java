package apiClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassPractice {
	public static void main(String[] args) throws Exception {
		Politicians p = new Politicians();
		PoliceStations p1 = new PoliceStations();
		p1.arrest(p);
	}
}

class Politicians{
	public String public_name="good man";
	public void PublicService(String s, int n) {
		System.out.println("getting nobel prize for helping people... "+ s + " = " + n);
	}
	private String secret_name="gunda...";
	private void SecretService(String s) {
		System.out.println("Hafta vasooli..." + s);
	}
}

class PoliceStations{
	public void arrest(Object suspect) throws Exception{
		Class c = suspect.getClass();
		Field f = c.getField("public_name");
		System.out.println(f.get(suspect));
		
		Field f2 = c.getDeclaredField("secret_name");
		f2.setAccessible(true);
		System.out.println(f2.get(suspect));
		
		Method m1 = c.getMethod("PublicService", String.class, int.class);
		m1.invoke(suspect, "hello", 10);
		
		Method m2 = c.getDeclaredMethod("SecretService", String.class);
		m2.setAccessible(true);
		m2.invoke(suspect, f2.get(suspect));
		
	}
}
