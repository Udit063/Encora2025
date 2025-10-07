package day2;
import java.util.Scanner;
public class FanPractice {
	public static void main(String[] args) {
		Fanss shaitan=new Fanss();
		while(true) {
			//Scanner scan=new Scanner(System.in);
			//System.out.println("Press a key and press enter...");
			//scan.next();
			shaitan.print();
		}
		//Fan khaitan=new Fan();
	}
}
class Fanss{
	FansBase fanb = new SwitchOnState();
	public void print() {
		fanb.pull(this);
	}
	
}

abstract class FansBase{
	public abstract void pull(Fanss fan);
}

class SwitchOnState extends FansBase{
	public void pull(Fanss fan) {
		fan.fanb = new MediumSpeedState();
		System.out.println("Switch on state ...");
	}
}

class MediumSpeedState extends FansBase{
	public void pull(Fanss fan) {
		fan.fanb = new HighSpeedState();
		System.out.println("Medium speed...");
	}
}

class HighSpeedState extends FansBase{
	public void pull(Fanss fan) {
		fan.fanb = new SwitchOffState();
		System.out.println("High speed...");
	}
}

class SwitchOffState extends FansBase{
	public void pull(Fanss fan) {
		fan.fanb = new SwitchOnState();
		System.out.println("Switch off state...");
	}
}