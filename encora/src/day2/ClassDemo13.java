package day2;
public class ClassDemo13 {
	public static void main(String[] args) {
		Teepoi teepoi=new Teepoi();
		teepoi.operateTv();
	}
}
class Teepoi{
	MyTvRemote mtr;
	MyVGameRemote mvgr;
	XBoxRemote xbr;
	SoundSystemRemote ssr;
	public Teepoi() {
		mtr=new MyTvRemote();
		mvgr=new MyVGameRemote();		
		xbr=new XBoxRemote();		
		ssr=new SoundSystemRemote();
	}
	public void operateTv() {
		mtr.switchOnTv();
		mtr.selectMode(1);
		mtr.openChannelMenu();
		mtr.newsChannel();
		ssr.loudNoise();
	}
}
class MyTvRemote{
	public void serialChannel() {
		System.out.println("serial channel on...");
	}
	public void newsChannel() {
		System.out.println("news channel on");
	}
	public void switchOnTv() {
		System.out.println("switch on tv...");
	}
	public void openChannelMenu() {
		System.out.println("Channel menu opened...");
	}
	public void selectMode(int choice) {
		if(choice==1) {
			System.out.println("tv mode....");
		}
		else {
			System.out.println("non tv mode...");
		}
	}
}
class MyVGameRemote{
	public void selectGame() {
		System.out.println("game selected....");
	}
	public void playGame() {
		System.out.println("play the game...");
	}
}
class XBoxRemote{
	public void selectGame() {
		System.out.println("xbox game selected....");
	}
	public void playGame() {
		System.out.println("play the xbox game...");
	}
}
class SoundSystemRemote{
	public void loudNoise() {
		System.out.println("loud noise selected....");
	}
	public void lowNoice() {
		System.out.println("low noise selected..");
	}
}