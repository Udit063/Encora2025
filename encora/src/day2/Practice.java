package day2;

public class Practice {
	public static void main(String[] args) {
		PaintBrushh pb = new PaintBrushh();
		pb.paintt = new BluePaintt();
		pb.doPaintt();
	}
}

class PaintBrushh{
	Paintt paintt;
	public void doPaintt() {
		paintt.color();
	}
}

abstract class Paintt{
	public abstract void color();
}

class RedPaintt extends Paintt{
	@Override
	public void color() {
		System.out.println("Red color...");
	}
}

class BluePaintt extends Paintt{
	@Override 
	public void color() {
		System.out.println("Blue color...");
	}
}