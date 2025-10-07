//package mindGym;
//public class mindGym8 {
//	public static void main(String[] args) throws Exception{
//		//First Scenario - multiton - more memory
////		Sheep obj1=new Sheep();
////		Sheep obj2=new Sheep();
////		obj1.name="sheep1";obj2.name="sheep2";
////		System.out.println(obj1+":"+obj2);
////		System.out.println(obj1.name+":"+obj2.name);
//		
//		//second scenario - singleton - data not safe
////		Sheep sobj1=new Sheep();
////		Sheep sobj2=sobj1;
////		sobj1.name="sheep 1111."; sobj2.name="sheep 222..";
////		System.out.println(sobj1.name+":"+sobj2.name);
////		
//		//third scenario - prototype - memory and data both are safe
//		// it will get stored in a stack, so whenever the class gets removed or stops the stack also get empty
//		Sheep mothersheep=new Sheep();
//		Sheep dolly=mothersheep.getClone();
//		mothersheep.name="iam the mother...";
//		dolly.name="iam the clone dolly..";
//		System.out.println(mothersheep.name+":"+dolly.name);
//		
//	}
//}
//class Sheep implements Cloneable{
//	public Sheep() {
//		System.out.println("sheep cons called...");
//	}
//	String name;
//	
//	public Sheep getClone() throws Exception{
//		return (Sheep)super.clone();
//	}
//}











package mindGym;

public class mindGym8{
	public static void main(String[] args) throws Exception {
		Sheep obj1 = new Sheep();
		Sheep obj2 = obj1.getClone();
		obj1.name = "Sheep1";
		obj2.name = "Sheep2";
		System.out.println(obj1.name + " and " + obj2.name);
	}
}

class Sheep implements Cloneable{
	String name;
	public Sheep() {
		System.out.println("sheep cons called...");
	}
	public Sheep getClone() throws Exception{
		return (Sheep)super.clone();
	}
}


