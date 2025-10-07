package week35;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIODemo7 {
	public static void main(String[] args) throws Exception {
		Laddu laddu = new Laddu();
		System.out.println("Original size : " + laddu.size);
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("laddu.dat"));
		oos.writeObject(laddu);
		laddu.size = 5;
		System.out.println("New size : " + laddu.size);
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("laddu.dat"));
		Laddu laddu2 = (Laddu)ois.readObject();
		System.out.println("New laddu size : " + laddu2.size);
	}
}
