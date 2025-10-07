package encora;

public class Animal {
    public static void main(String[] args) throws Exception {
    	// this is statically called constructor
        Animals obj = new Animals();
//        System.out.println(obj.name);
        
        // I can have the dynamic constructor also which can be changed at runtime using class Class which is predefined in java
        Class.forName("encora.Animals").getConstructor(String.class).newInstance("helloo");
        Class.forName("encora.Animals").getConstructor(String.class, int.class).newInstance("hi", 20);
    }
}

class Animals{
    String name; 
    // Constructor, called automatically when the object is created
    // some things need to be initialized before creating an object, that's why we use constructors
    public Animals(){
        System.out.println("Animal default cons called");
    }
    
    // You can create as many constructors as many you want but with different parameters - overloading
    public Animals(String name){
        // name can't be same as parameters as it will give null only otherwise use this
        this.name=name;
        System.out.println("String name cons...." + name);
    }
    
    public Animals(String name, int age) {
    	System.out.println("String-int name cons..." + name + " : " + age);
    }
}