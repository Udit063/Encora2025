package mindGym;
public class MindGym4 {
}
// implementation and then subjection
interface Doctor{
	public abstract void doCure();
	private void met() {}
	public default void meet() {}
	//they cannot have constructor
}
interface Surgeon extends Doctor{//interface can extend another interface
	
}
interface Nurse{}
interface Pilot{
	
}
//implementation
class AlopathyMedicalCollege implements Surgeon,Nurse{
	@Override
	public void doCure() {
		System.out.println("do cure called.english medicine..");
	}
}
class AyurvedMedicalCollege implements Doctor{
	@Override
	public void doCure() {
		System.out.println("ayurved do cure called...");
	}
}
class JetAcademy implements Pilot{
	
}

