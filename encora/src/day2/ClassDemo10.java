package day2;
import java.util.Scanner;

public class ClassDemo10 {
	public static void main(String[] args) {
		FanBase shaitan=new FanBase();
		while(true) {
			//Scanner scan=new Scanner(System.in);
			//System.out.println("Press a key and press enter...");
			//scan.next();
			shaitan.print();
		}
		//Fan khaitan=new Fan();
	}
}

class FanBase{
	Fan fan = new Fan0();
	public void print() {
		fan.print(this);
	}
}

abstract class Fan{
	public abstract void print(FanBase fanb);
}

class Fan0 extends Fan{
	@Override
	public void print(FanBase fanb) {
		fanb.fan= new Fan1();
		System.out.println("switch on state....");
	}
}

class Fan1 extends Fan{
	@Override
	public void print(FanBase fanb) {
		fanb.fan = new Fan2();
		System.out.println("medium speed state....");
	}
}

class Fan2 extends Fan{
	@Override
	public void print(FanBase fanb) {
		fanb.fan = new Fan3();
		System.out.println("high speed state....");
	}
}

class Fan3 extends Fan{
	@Override
	public void print(FanBase fanb) {
		fanb.fan = new Fan0();
		System.out.println("switch off state....");
	}
}