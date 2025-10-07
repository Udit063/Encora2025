package week34;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
//class MyFunction implements Function<List<String>, String>{
//	@Override
//	public String apply(List<String> t) {
//		// TODO Auto-generated method stub
//		return t.get(0);
//	}
//}

//class MyConsumer implements Consumer<String>{
//	@Override
//	public void accept(String t) {
//		System.out.println("Hello is found...");
//	}
//}
//class MyRunnable implements Runnable{
//	@Override
//	public void run() {
//		System.out.println("else condition for hello...");
//	}
//}
public class OptionalDemo {
	public static void main(String[] args) {
		Object obj=null;
		
		Optional op=Optional.empty();//returns a empty optional object
		System.out.println(op);
//		op=Optional.of(obj);//throws a nullpointer exception
//		op=Optional.ofNullable(obj);;//returns a optional object
//		System.out.println(op);
		List<String> list=getList(1);
		Stream s=Optional.ofNullable(getList(0))//use ofNullable for all unknown object reading
				.map((n)->{return n.stream();})
				.orElse(Stream.empty());
		
		System.out.println(s);
		
		
//		//scenario 1
		
		String result=Optional.ofNullable(list)
		.map(n->n.get(0))//when the object is not null
		.orElse("null object");//this will work when object is null
		System.out.println(result);
		
//		
//		if(list!=null) {
//			System.out.println(list.get(0));
//		}
//		else {
//			System.out.println("null object...");
//		}
		//Scenario 2
		String st="Hello";
		if(st.equals("hello")) {
			if(st.charAt(0)=='H') {
				System.out.println("success.");
			}
		}
		else {
			System.out.println("failure..");
		}
		 result=Optional.ofNullable(st)
		.filter((str)->str.equals("Hello"))
		.filter((str)->str.charAt(0)=='H')
		.map(n->"success")
		.orElse("failure...");
		System.out.println(result);
		
		//Scenario 3
		st="world";
		if(st.equals("hello")) {
			if(st.charAt(0)=='H') {
				System.out.println("hello success.");
			}
			else {
				System.out.println("..,,..,,..");
			}
		}
		else if(s.equals("world")){
			System.out.println("hello world success..");
		}
		Optional.ofNullable(st)
	    .filter(str -> str.equals("Hello") && str.charAt(0) == 'H')
	   // .ifPresentOrElse((stt)->System.out.println("hello success"+stt), ()->{System.out.println(",,..,,..");});
	    .ifPresentOrElse((sttt)->System.out.println("hello.... found.."), ()->System.out.println("else part..."));
	    

		Optional.ofNullable(st)
	    .filter(str -> str.equals("world"))
	    .ifPresent(str -> System.out.println("hello world success.."));
	}
	
	static List<String> getList(int i){
		if(i==0) {
			return null;
		}
		else {
			List<String> al=new ArrayList<String>();
			al.add("hello world..........................");
			return al;
		}
	}
	
}

