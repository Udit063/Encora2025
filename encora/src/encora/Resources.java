package encora;

public class Resources {
    public static void main(String[] args) {
        Resource obj = Resource.newInstance();
        System.out.println("Print1");
        obj.anotherStaticMethod();
        Resource.anotherStaticMethod();
    }
}

class Resource{
    static{
        System.out.println("static block called...");
    }
    //outer classes can't access this class as it is private, only this class can create an object
    private Resource(){
        System.out.println("Resource object created");
    }
    
    // if you want to create an object using this class using outside class but using the static keyword and add a new name to it
    // static - factory --> as it is returning the instance of that class only
    public static Resource newInstance(){
        return new Resource();
    }
    
    // static - business --> as it is not returning the instance of the class, just return something else
    public static void anotherStaticMethod(){
        System.out.println("Another static method");
    }
}