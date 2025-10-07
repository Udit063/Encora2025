//package mindGym;
// 
//// Client code
//public class Adaptor_Pattern {
//	public static void main(String[] args) {
//        TypeCCharger myTypeC = new TypeCCharger();
//        USBCharger adapter = new TypeCToUSBAdapter(myTypeC);
// 
//        adapter.charge(); // Output: Charging with Type-C charger.
//    }
//}
//// Target Interface
//	interface USBCharger {
//	    void charge();
//	}
// 
//	// Adaptee (existing incompatible class)
//	class TypeCCharger {
//	    public void typeCCharge() {
//	        System.out.println("Charging with Type-C charger.");
//	    }
//	}
// 
//	// Adapter class (implements target, uses adaptee)
//	class TypeCToUSBAdapter implements USBCharger {
//	    private TypeCCharger typeCCharger;
// 
//	    public TypeCToUSBAdapter(TypeCCharger typeCCharger) {
//	        this.typeCCharger = typeCCharger;
//	    }
// 
//	    @Override
//	    public void charge() {
//	        typeCCharger.typeCCharge(); // adapts call
//	    }
//	}




package mindGym;

public class Adaptor_Pattern{
	public static void main(String[] args) {
		OldPrinter op = new OldPrinter();
		PrintAdapter p = new PrintAdapter(op);
		
		p.ConnectWithUSB();
	}
}

interface USBDevice {
	void ConnectWithUSB();
}

class OldPrinter{
	public void ConnectWithParallelPort() {
		System.out.println("Connected via parallel port...");
	}
}

class PrintAdapter implements USBDevice{
	OldPrinter oldPrinter;
	public PrintAdapter(OldPrinter oldPrinter) {
		this.oldPrinter = oldPrinter;
	}
	public void ConnectWithUSB() {
		oldPrinter.ConnectWithParallelPort();
	}
}
