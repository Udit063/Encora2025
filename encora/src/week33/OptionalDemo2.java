package week33;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo2 {
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
		//Scenario 2
		String s="Hello";
		if(s.equals("hello")) {
			if(s.charAt(0)=='H') {
				System.out.println("success.");
			}
		}
		else {
			System.out.println("failure..");
		}
		String result=Optional.ofNullable(s)
		.filter((str)->str.equals("Hello"))
		.filter((str)->str.charAt(0)=='H')
		.map(n->"success")
		.orElse("failure...");
		System.out.println(result);
		
		//Scenario 3
		s="Hello";
		if(s.equals("hello")) {
			if(s.charAt(0)=='H') {
				System.out.println("hello success.");
			}
		} 
		else if(s.equals("world")){
			System.out.println("hello world success..");
		}
		
		
		String s1 = Optional.ofNullable(s).filter((str)->str.equals("Hello") && str.charAt(0)=='H').map(n->"hello success").orElse("failure");
		System.out.println("output: " + s1);
		
		String s2="worlds";
		
		Optional.ofNullable(s2).filter(str -> str.equals("world")).ifPresent(str -> System.out.println("hello2 success"));
		
		
		
		Optional.ofNullable(s)
	    .filter(str -> str.equals("hello") && str.charAt(0) == 'H')
	    .ifPresent(str -> System.out.println("hello success."));

	Optional.ofNullable(s)
	    .filter(str -> str.equals("world"))
	    .ifPresent(str -> System.out.println("hello world success.."));
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

