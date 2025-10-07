//package mindGym;
////Builder Pattern
//public class MindGym7 {
//	public static void main(String[] args) {
//		Computer mycomputer=new MindGym7()
//				.new Computer()
//				.setCabinet(new MindGym7().new Cabinet())
//				.build();
//		System.out.println(mycomputer);
//	}
//	class Computer{
//		Cpu cpu; Ram ram;Cabinet cabinet;
//		public Computer() {
//			
//		}
//		public Computer(Cpu cpu, Ram ram, Cabinet cabinet) {
//			this.cpu = cpu;
//			this.ram = ram;
//			this.cabinet = cabinet;
//		}
//		public Computer setCpu(Cpu cpu) {
//			this.cpu=cpu;
//			return this;
//		}
//		public Computer setRam(Ram ram) {
//			this.ram=ram;
//			return this;
//		}
//		public Computer setCabinet(Cabinet cabinet) {
//			this.cabinet=cabinet;
//			return this;
//		}
//		public Computer build() {
//			return new Computer(cpu,ram,cabinet);
//			//return new this;
//		}
//		@Override
//		public String toString() {
//			return "Computer [cpu=" + cpu + ", ram=" + ram + ", cabinet=" + cabinet + "]";
//		}
//		
//	}
//	class Cpu{
//		@Override
//		public String toString() {
//			return "Cpu []";
//		}
//		
//	}
//	class Ram{
//		@Override
//		public String toString() {
//			return "Ram []";
//		}
//		
//	}
//	class Cabinet{
//		@Override
//		public String toString() {
//			return "Cabinet []";
//		}
//		
//	}
//}
//



package mindGym;

// Builder Patterns
public class MindGym7_Builder{
	public static void main(String[] args) {
		Computer c = new MindGym7_Builder().new Computer().setCabinet(new MindGym7_Builder().new Cabinet()).setCPU(new MindGym7_Builder().new CPU()).build();
		System.out.println(c);
	}
	
	class Computer{
		Ram ram; Cabinet c; CPU cpu;
		public Computer() {
			
		}
		public Computer(Ram ram, Cabinet c, CPU cpu) {
			this.ram = ram;
			this.c = c;
			this.cpu = cpu;
		}
		
		public Computer setRam(Ram ram) {
			this.ram=ram;
			return this;
		}
		
		public Computer setCabinet(Cabinet c) {
			this.c=c;
			return this;
		}
		
		public Computer setCPU(CPU cpu) {
			this.cpu=cpu;
			return this;
		}
		
		public Computer build() {
			return new Computer(ram, c, cpu);
		}
		
		@Override
		public String toString() {
			return "Computer [cpu=" + cpu + ", ram=" + ram + ", cabinet=" + c + "]";
		}
	}
	
	class Ram{
		@Override
		public String toString(){
			return "Ram []";
		}
	}
	
	class Cabinet{
		@Override
		public String toString() {
			return "Cabinet []";
		}
	}
	
	class CPU{
		@Override
		public String toString(){
			return "CPU []";
		}
	}
}
