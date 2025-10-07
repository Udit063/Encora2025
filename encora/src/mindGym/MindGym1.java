package mindGym;

public class MindGym1 {
	//VARIABLES
	//Number Data Types
	//instance variables are also initialized by default
	//static variables are also initialized by default
	//static variables can only be declared outside the methods
	//keywords for Access Specifiers and Access modifiers
	/*
	 * PUBLIC - GLOBAL ACCESS
	 * PROTECTED - RELATIONSHIP ACCESS
	 * PRIVATE - CLASS ACCESS
	 * NO MODIFIER - PACKAGE ACCESS
	 *
	 * TRANSIENT - VARIABLE VALUE IS NOT STORED DURING SERIALIZATION
	 * VOLATILE - A TEMPORARY COPY IS NOT CREATED BY THREADS FOR DYNAMIC ACCESS
	 * FINAL - TO DECLARE CONSTANTS
	 */
	byte b=127;//8 bit
	short s=32767;//16 bit
	int i=-243243244;//32 bit
	long lo=84093840932L;
	//VARIABLES declared outside the methods and inside class are called INSTANCE VARIABLES
	//VARIABLES with STATIC keyword are referred as CLASS VARIABLES
	void met() {//variables declared inside a method are called LOCAL VARIABLES
		//static int i; - i cannot have a static variables declared inside a method
		b=(byte)s;//type casting is mandatory for holding a bigger type to small type
		float f=1.3f;//32 bit
		int n=(int)f;//the decimals will be lost
		f=n;//no need for type casting
		int nn=257;
		byte bb=(byte)257;
		//System.out.println(bb);//1 - Reason - the value 257 is divided by 256(size of byte) and
		//the reminder is returned as answer
		i=10;
		System.out.println(i++);//10 - post increment - prints first and then increment
		System.out.println(i);//11
		i=10;
		System.out.println(++i);//11 - pre increment - increments first and then prints
		System.out.println(i);//11
	}
	
	//ARRAYS
	void arrayDemo() {
		int arr[]=new int[5];//this creates a single dimensional array - with 1 row and 5 columns
		//Arrays index always starts with zero
		//arrays are by default objects
		//Arrays are initialized by default
		//Arrays have a property by name LENGTH - which gives the length of the array
		int []arr2= {10,20,30,40,50};//5 columns and 1 row
		for(int i=0;i<arr2.length;i++) {//arr2.length will give me the number of columns
			System.out.println(arr2[i]);
		}
		//jdk for loop
		for(int x:arr2) {
			System.out.println(x);
		}
		int twod1[][]=new int[3][4];//4 columns and 3 rows
		int twod[][]= {
				{10,20,30,40},
				{100,200,300,400},
				{1000,2000,3000,4000}
		};
		System.out.println(twod.length);//will give me number of rows in a two dimensional array
		System.out.println(twod[0].length);//will give me number of columns in the first row
		
		for(int i=0;i<twod.length;i++) {
			for(int j=0;j<twod[i].length;j++) {
				System.out.print(twod[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int x[]:twod) {
			for(int i:x) {
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		//uneven multi dimensional array
		int xx[][]=new int[3][];
		xx[0]=new int[2];
		xx[1]=new int[5];
		xx[2]=new int[3];
		
		//Remember - Arrays are always pass by reference
	}
	
	static void pbv(int i) {
		i=5;
	}
	
	static void pbr(int x[]) {
		x[0]=9999;
	}
	static void pbr2(Laddu laddu) {
		laddu.size=5;
	}
	
	public static void main(String[] args) {
		MindGym1 obj=new MindGym1();
		//obj.met();
		//obj.arrayDemo();
		int arr[]= {10,20,30,40};
		/*
		 * Static methods cannot access non static properties
		 * static methods cannot have this or super keyword
		 * static variables cannot be declared inside a method
		 */
		System.out.println("Before array passing...:"+arr[0]);
		pbr(arr);
		System.out.println("After array Passing...:"+arr[0]);//this happens because of reference passing
		//solution
		int arrcopy[]=new int[4];
		System.arraycopy(arr, 0, arrcopy, 0, 4);
		System.out.println("Before array passing...:"+arr[0]);
		pbr(arrcopy);
		System.out.println("After array Passing...:"+arr[0]);//this happens because of reference passing
		
		Laddu laddu=new Laddu();
		System.out.println("Before passing laddus variable..:"+laddu.size);
		pbv(laddu.size);
		System.out.println("After passing laddus variable.."+laddu.size);
		
		System.out.println("Before passing laddu..:"+laddu.size);
		pbr2(laddu);
		System.out.println("After passing laddus.."+laddu.size);
		
	}
}
class Laddu{
	int size=10;
}