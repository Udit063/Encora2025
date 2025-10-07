package day2;

public class ClassDemo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintBrush brush = new PaintBrush();
		brush.paint = new RedPaint();
		brush.doPaint();

	}

}

class PaintBrush{
	Paint paint;
	public void doPaint() {
		
		// for removing if-else if, first change to classes and all
//		if(i==0) {
//			System.out.println("red paint");
//		} else if(i==1) {
//			System.out.println("blue paint");
//		}
		
		paint.color();
	}
}

abstract class Paint{ // as i want no one to create an object for paint
	public abstract void color();	
}  
class RedPaint extends Paint{
	@Override
	public void color(){
		System.out.println("red color...");
	}
}
class BluePaint extends Paint{
	@Override
	public void color(){
		System.out.println("blue color...");
	}
}
class GreenPaint extends Paint{
	@Override
	public void color(){
		System.out.println("green color...");
	}
}