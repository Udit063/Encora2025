package week33;

import java.util.Optional;

public class OptionalDemo3 {
	public static void main(String[] args) {
		Object obj=null;
		
		if(obj==null) {
			System.out.println("object is null");
		}
		else {
			System.out.println("obj is not null");
		}
		Optional.of(obj);
		 Optional<Object> optionalObj = Optional.ofNullable(obj);

	     System.out.println(optionalObj.orElse("object is null"));
	     
	     Optional.ofNullable(obj)
	        .map(o -> "obj is not null")
	        .orElse("object is null");
	     
	     if(obj!=null) {
	    	 if(obj instanceof String) {
	    		 
	    	 }
	    	 else {
	    		 
	    	 }
	     }
	    	 else {
	    		 
	    	 }
	     
	 obj = "Hello";

	 String result = Optional.ofNullable(obj)
	         .filter(o -> o instanceof String)              // keep only Strings
	         .map(o -> "It is a String: " + o)              // what to do if String
	         .orElse("Object is null OR not a String");     // fallback
	 System.out.println(result);
	 String s="hello";
	 if(s.equals("hello")) {
		 if(s.charAt(1)=='h') {
			 int i=s.length();
			 if(s.charAt(s.length()-1)=='o') {
				 
			 }
		 }
	 }
	 s=null;
	 result = Optional.ofNullable(s)
             .filter(str -> str.equals("hello"))
             .filter(str -> str.charAt(1) == 'h')
             .filter(str -> str.charAt(str.length() - 1) == 'o')
             .map(str -> "All conditions passed, length = " + str.length())
             .orElse("the object is null");
     System.out.println(result);
     Optional.ofNullable(s)
             .filter(str -> str.equals("hello"))
             .filter(str -> str.charAt(1) == 'h')
             .filter(str -> str.charAt(str.length() - 1) == 'o')
             .ifPresent(str -> {
                 // Only runs if all conditions passed
                 System.out.println("All conditions passed, length = " + str.length());
             });
     Optional.ofNullable(s)
     .filter(str -> str.equals("hello"))
     .filter(str -> str.charAt(1) == 'h')
     .filter(str -> str.charAt(str.length() - 1) == 'o')
     .ifPresentOrElse(
             str -> System.out.println("✅ All conditions passed, length = " + str.length()),
             () -> System.out.println("❌ Condition failed or string was null")
     );
     String msg=null;
//     Optional<String> str=Optional.of(msg);
     	Optional.ofNullable(msg)
     // "world" is created even though not needed
     //result = str.orElse("world");
     //System.out.println(result);
     .orElseThrow(() -> new IllegalArgumentException("Value missing!"));
     
	}
	
}
