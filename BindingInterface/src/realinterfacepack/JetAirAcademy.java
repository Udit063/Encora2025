package realinterfacepack;

public class JetAirAcademy implements Pilot,Steward{
	
@Override
public void doFly() {
	System.out.println(" I am flying..............");
}
@Override
	public void doServe() {
		System.out.println("i do serve in flight as I was taught....");
	}
}

