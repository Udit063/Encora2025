package week33;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
	public static void main(String[] args) {
		Object obj=null;
		
		Optional op=Optional.empty();//returns a empty optional object
//		System.out.println(op);
//		//op=Optional.of(obj);//throw nullpointer exception
//		op=Optional.ofNullable(obj);;//returns a optional object
//		System.out.println(op);
//		List<String> list=getList(1);
//		//scenario 1
//		String result=Optional.ofNullable(list)
//		.map(n->n.get(0))//when the object is not null
//		.orElse("null object");//this will work when object is null
//		System.out.println(result);
//		
//		if(list!=null) {
//			System.out.println(list.get(0));
//		}
//		else {
//			System.out.println("null object...");
//		}
		//Scenario
		String s="Hello";
		if(s.equals("hello")) {
			if(s.charAt(0)=='H') {
				System.out.println("success.");
			}
		}
		else {
			System.out.println("failure..");
		}
		
		String res = Optional.ofNullable(s).filter((str)-> str.equals("He=llo")).filter((str)->str.charAt(0)=='H').
		map(n->"success").orElse("failure");
		
		System.out.println("res " + res);
		
		String result=Optional.ofNullable(s)
		.filter((str)->str.equals("Hello"))
		.filter((str)->str.charAt(0)=='H')
		.map(n->"success")
		.orElse("failure...");
		System.out.println(result);
		
		//Scenario 3
		
	}
	
	static List<String> getList(int i){
		if(i==0) {
			return null;
		}
		else {
			List<String> al=new ArrayList<String>();
			al.add("hello world");
			return al;
		}
	}
	
}