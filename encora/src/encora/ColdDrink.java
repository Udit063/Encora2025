package encora;

public class ColdDrink {
	public static void main(String[] args) {
		Cola campaCola = new Cola();
		Pepsi pepsi = new Pepsi();
		System.out.println(campaCola);
		campaCola.makeCola();
		System.out.println(pepsi);
		pepsi.makeCola();        
	}
}

class Cola{
	public void makeCola(){
		System.out.println("Cola made by cola company....");
	}
	
}

class Pepsi{
	public void  makeCola() {
		Cola cola = new Cola();
		cola.makeCola();
		System.out.println("Pepsi fill in bottle and sell");
	}
}

