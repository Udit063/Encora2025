package lifecycle;

public class ComputerShopTest{
	public static void main(String[] args) {
		ComputerShop.Computer c = new ComputerShop.Computer().setRam(new ComputerShop.Ram()).build();
		System.out.println(c);
	}
	public static class Computer{
		Ram ram;
		Cabinet c;
		CPU cpu;
		
		public Computer() {
			System.out.println("lets start...");
		}
		
		public Computer (Ram ram, Cabinet c, CPU cpu) {
			this.ram=ram;
			this.c = c;
			this.cpu = cpu;
		}
		
		public Computer build(Ram ram, Cabinet c, CPU cpu) {
			return new Computer(ram,c,cpu);
		}
		
		public Computer setRam(Ram ram) {
			this.ram=ram;
			return this;
		}
		
		public String toString() {
			return "The compiler is made... " + cpu + " : " + ram + " : " + c;
		}
	}
	
	static class Ram{}
	static class Cabinet{}
	static class CPU{}
}

