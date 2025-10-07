package encora2;

import java.io.FileReader;
import java.io.FileWriter;

public class WriterIODemo2 {
	public static void main(String[] args) {
//		FileReader in = null;
//		FileWriter out = null;
//		try {
//			int i=0;
//			char c[] = new char[4];
//			out = new FileWriter("copy.txt");
//			in = new FileReader("abc.txt");
//			System.out.println("kya scene h");
//			while((i=in.read(c))!=-1) {
//				out.write(c,0,i);
//				System.out.println(c);
//			}
//		} catch(Exception e) {
//			
//		} finally {
//			try{out.close();} catch(Exception e) {}
//		}
		
		try(
				FileWriter out = new FileWriter("copy.txt"); 
				FileReader in = new FileReader("abc.txt");
				){
			int i=0;
			char c[] = new char[5];
			while((i=in.read(c))!=-1) {
				out.write(c,0,i);
				System.out.println(c);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
