package lifecycle;

public class ComputerShop {
	public static void main(String[] args) throws Exception {
		// calling inner classes
		// ComputerShop.Computer myComputer = new ComputerShop().new Computer();
		// for static
		// ComputerShop.Computer c = new ComputerShop.Computer().build();
		
		ComputerShop.Computer c = new ComputerShop.Computer().setRam(new ComputerShop.Ram()).setCabinet(new ComputerShop.Cabinet()).setCPU(new ComputerShop.CPU()).build();
		
		System.out.println(c);
	}
	static class Computer{
		Ram ram; Cabinet c; CPU cpu;
		public Computer() {
			System.out.println("Let's start...");
		}
		
		public Computer(Ram ram, Cabinet c, CPU cpu) {
			this.ram = ram;
			this.cpu=cpu;
			this.c=c;
		}
		
		public Computer build() {
			return new Computer(ram, c, cpu);
		}
		
		public Computer setRam(Ram ram) {
			this.ram=ram;
			return this;
		}
		
		public Computer setCPU(CPU cpu) {
			this.cpu=cpu;
			return this;
		}
		
		public Computer setCabinet(Cabinet c) {
			this.c = c;
			return this;
		}
		
		public String toString() {
			return "The compiler is made... " + cpu + " : " + ram;
		}
	}
	
	static class Ram{}
	
	static class CPU{}
	
	static class Cabinet{}
}
