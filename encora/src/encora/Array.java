package encora;
import java.util.*;

public class Array {
	public static void main(String[] args) {
		int a[]= new int[5];
		a[1]=999;
		System.out.println(a[1]);
		System.out.println(a.length);
		
		int []aa = {10,20,30,40,50};   //pre-initialized
		for(int i=0;i<aa.length;i++) {
			System.out.println(aa[i]);
		}
		
		int bb[]=aa;    // both variables point/refer to same array, nothing new created
//		bb[0]=999;
//		System.out.println(aa[0]);
		System.out.println("--------------");
		
		int bbb[]= new int[5];
		System.arraycopy(aa, 0, bbb, 0, 5);
		System.out.println(aa[0]);
		bbb[0]=888;
		System.out.println(aa[0]);
		System.out.println(bbb[0]);

	}
}
