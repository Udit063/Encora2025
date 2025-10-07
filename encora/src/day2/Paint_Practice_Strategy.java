//package day2;
//
//public class Paint_Practice {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		PaintBrushes pb = new PaintBrushes();
//		pb.paint = new BluePaints();
//		pb.doPaints();
//	}
//
//}
//
//class PaintBrushes{
//	Paints paint;
//	public void doPaints() {
//		paint.colors();
//	}
//}
//
//abstract class Paints{
//	abstract public void colors();
//}
//
//class RedPaints extends Paints{
//	@Override
//	public void colors() {
//		System.out.println("Red color it is...");
//	}
//}
//
//class BluePaints extends Paints{
//	@Override
//	public void colors() {
//		System.out.println("blue color it is...");
//	}
//}
package day2;

// strategy pattern
public class Paint_Practice_Strategy{
	public static void main(String[] args) {
		PaintsBrush pb = new PaintsBrush();
		pb.paint = new ReddPaints();
		pb.doPaint();
		
	}
}

class PaintsBrush{
	Paints paint;
	public void doPaint() {
		paint.colors();
	}
}

abstract class Paints{
	abstract public void colors();
}

class ReddPaints extends Paints{
	public ReddPaints() {
		
	}
	public void colors() {
		System.out.println("red color...");
	}
}

class BluesPaints extends Paints{
	public BluesPaints() {
		
	}
	public void colors() {
		System.out.println("blue colors...");
	}
}