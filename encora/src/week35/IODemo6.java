package week35;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IODemo6 {
	public static void main(String[] args)throws Exception {
		FileInputStream fis = new FileInputStream("dictionary.properties");
		FileOutputStream fos = new FileOutputStream("copy.properties");
		int i=0;
		
		// make the size of the file in the array to check the size of the file
		// but this is not the right way, as if its a large file then array size will be much larger
		/* byte b[] = new byte[fis.available()];
		while((i=fis.read()) !=-1) {
			System.out.println((char)i);
		} 
		
		while(fis.read(b)!=-1) {
			String s = new String(b);
			System.out.println(s);
		} */
		
		byte b[] = new byte[4];
		while((i=fis.read(b))!=-1) {
			String s = new String(b, 0, i);
			System.out.println(s);
			fos.write(b, 0, i);
		}
		
	}
}
