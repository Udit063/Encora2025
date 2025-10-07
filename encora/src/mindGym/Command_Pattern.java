//package mindGym;
//
////COMMAND PATTERN
//public class Command_Pattern {
//	public static void main(String[] args) {
//		PoliceStation p1 = new PoliceStation();
//		Corporation cc = new Corporation();
//		Hospital gh = new Hospital();
//		Command deathCommand = new DeathCertificateCommand(gh,cc,p1);
//		
//		RealSeva seva = new RealSeva();
//		seva.setCommand(1, deathCommand);
//		seva.runCommand(1);
//	}
//}
//class RealSeva{
//	Command commands[] = new Command[5];
//	public RealSeva() {
//		for(int i=0; i<commands.length; i++) {
//			commands[i] = new DummyCommand();
//		}
//	}
//	public void setCommand(int slot, Command command) {
//		commands[slot] = command;
//	}
//	public void runCommand(int slot) {
//		commands[slot].execute();
//	}
//}
//class Hospital{
//	//private Hospital() {}
//	public  void doPostMortem() {
//		System.out.println("Post Mortem Done.");
//	}
//}
//class Corporation{
//	//private Corporation() {}
//	public  void doGiveDeathCertificate() {
//		System.out.println("Death Certificate Made.");
//	}
//}
//class PoliceStation{
//	//private PoliceStation() {}
//	public  void doInvestigation() {
//		System.out.println("Police doing investigation.");
//	}
//}
//abstract class Command{
//	public Command() {
//		// TODO Auto-generated constructor stub
//	}
//	Hospital hospital;Corporation corporation;PoliceStation policeStation;
//	
//	public Command(Hospital hospital, Corporation corporation, PoliceStation policeStation) {
//		this.hospital = hospital;
//		this.corporation = corporation;
//		this.policeStation = policeStation;
//	}
//	public abstract void execute();
//}
//
//class DummyCommand extends Command{
//	@Override
//	public void execute() {
//		System.out.println("Dummy Command");
//	}
//}
//class DeathCertificateCommand extends Command{
//	public DeathCertificateCommand() {
//		// TODO Auto-generated constructor stub
//	}
//	public DeathCertificateCommand(Hospital h, Corporation c, PoliceStation ps) {
//		super(h, c, ps);
//	}
//	@Override
//	public void execute() {
//		//logic to execute the command
//		System.out.println("The process of Death certificate started...");
//		this.policeStation.doInvestigation();
//		this.hospital.doPostMortem();
//		this.corporation.doGiveDeathCertificate();
//		System.out.println("Process over...take the Death certificate...");
//		
//	}
//	
//}

package mindGym;
public class Command_Pattern{
	public static void main(String[] args) {
		Light light = new Light();
		Command lightOn = new LightOnCommand(light); 
		RemoteControl r = new RemoteControl();
		
		r.setCommand(lightOn);
		r.pressButton();
	}
}

interface Command{
	void execute();
}

class Light{
	public void on() {
		System.out.println("light is on");
	}
	public void off() {
		System.out.println("light is off");
	}
}

class LightOnCommand implements Command{
	Light light;
	LightOnCommand(Light light){
		this.light=light;
	}
	public void execute() {
		light.on();
	}
}

class LightOffCommand implements Command{
	Light light;
	LightOffCommand(Light light){
		this.light=light;
	}
	public void execute() {
		light.off();
	}
}

class RemoteControl{
	Command command;
	public void setCommand(Command command) {
		this.command=command;
	}
	public void pressButton() {
		command.execute();
	}
}