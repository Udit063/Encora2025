package apiClass;

public class GenricDemo {
	public static void main(String[] args) {
		Gen<A> obj=new Gen<>();
		A a=new A();
		B b=new B();
		obj.accept(a);
		
		a=obj.get();
		
	}
}

class Gen<T>{
//	Object o;
//	public void accept(Object o) {
//		this.o=o;
//	}
//	A o;
//	public void accept(A obj) {
//		this.o=obj;
//	}
	public T get() {
		return o;
	}
	T o;
	public void accept(T obj) {
		this.o=obj;
	}
}

class A{
	
}
class B{
	
}