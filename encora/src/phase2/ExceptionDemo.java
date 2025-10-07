package phase2;

public class ExceptionDemo {
	public static void main(String[] args) {
//		System.out.println("before exception....");
//		try {
//			int i=1/Integer.parseInt(args[0]);
//		}catch(ArithmeticException e) {
//			
//		}catch(ArrayIndexOutOfBoundsException ae) {
//			
//		}catch(NumberFormatException ne) {
//			
//		}catch(Exception ee) {
//			
//		}
//		System.out.println("after exception...");

		System.out.println("before exception....");
		if(args.length==0) {
			System.out.println("Please enter a command line argument...");
		}
		else {
			String a=args[0];
			if(Character.isDigit(a.charAt(0))) { // character have isDigit but char doesn't
				int x=Integer.parseInt(args[0]); // integer have parseInt but int doesn't
				if(x==0) {
					System.out.println("Please enter a non zero value...");
				}
				else {
					int i=1/x;
				}
			}
			else {
				System.out.println("please enter a number value...");
			}
		}
		System.out.println("after exception...");
	}
}
