package mindGym;
public class MindGym5 {
	public static void main(String[] args) {
		Pepsi pepsico=new Pepsi();
		pepsico.makeCola();
		
		Kalimark kali=new Kalimark();
		kali.makeCola();
	}
}
interface CampaCola{
	public void makeCola();
}
class Pepsi{
	public void makeCola() {
		//CampaCola cc=new Kalimark(). new CampaColaImpl();
		//CampaCola cc=new Kalimark.CampaColaImpl();//syntax for static
		//CampaCola cc=new Kalimark().chor();
		//cc.makeCola();
		System.out.println("pepsi fills in pepsi bottle and sell");
	}
}
class Kalimark{
	public void makeCola() {
//		class CampaColaImpl implements CampaCola{
//			public void makeCola() {
//				System.out.println("campa cola creates cola....");
//			}
//		}
		
		//CampaCola cc=new CampaCola() 	
		new CampaCola() {//anonymous inner class implementation
			@Override
			public void makeCola() {
				System.out.println("cola created as per campa cola logic..");
			}
		}.makeCola();
		
		//cc.makeCola();
		System.out.println("kalimark fills in bovonto bottle and sell");
	}
//	public CampaCola chor() {
//		return new CampaColaImpl();
//	}
	//inner class - more encapsulation...
	
}
