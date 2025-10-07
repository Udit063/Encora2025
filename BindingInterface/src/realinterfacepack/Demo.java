package realinterfacepack;

import java.lang.reflect.Proxy;
import java.util.Scanner;
interface A{}
public class Demo {
	//private static Class c[]={Doctor.class,Pilot.class,Steward.class};
	public static void main(String[] args) {
		AlopathyMedicalCollege stanelyMC=new AlopathyMedicalCollege();	//1953
		AyurvedCollege ayush=new AyurvedCollege();//2018
		Object shoiab=new Human(); //1974
		Scanner scan=new Scanner(System.in);
		System.out.println("Press enter to continue...");
		scan.next();
		
		//today checking - 26/09/2025
		if(shoiab instanceof Doctor){
			System.out.println("shoiab is a doctor...");
		}else{
			System.out.println("shoiab is not a doctor");
		}
////		Doctor doctor=(Doctor)shoiab;
		System.out.println("shoiab goes to medical college.....");
////		//subject myself to the implementation of Doctor
		MoleculeFramework.setInterface(Doctor.class);
		shoiab=
			MoleculeFramework.getObject
			(new Object[]{shoiab,ayush});//dynamic binding
		if(shoiab instanceof Doctor){
			System.out.println("shoiab is now a doctor after mixing");
		}
				Doctor doctorshoiab=(Doctor)shoiab;
				doctorshoiab.doCure();
//////////////////////////////		
				JetAirAcademy ja=new JetAirAcademy();
////////////////		
		MoleculeFramework.setInterface(Pilot.class);
		MoleculeFramework.setInterface(Steward.class);
	shoiab=MoleculeFramework.getObject
		(new Object[]{shoiab,ja});//dynamic binding with pilot
//////		
		Pilot pilot=(Pilot)shoiab;
		pilot.doFly();
		doctorshoiab=(Doctor)shoiab;
		doctorshoiab.doCure();
//////////		
//////////		
	}
}
