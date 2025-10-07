package mindGym;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

//strategy and state pattern
public class MindGym11GenricsStrategy_State {
	public static void main(String[] args)throws Exception {
//		GoodPaintBrush<Paint> brush=PaintContainer.getPaintBrush();
//		
//		Paint p=brush.getObj();
//		
//		p.color();
		
		GoodPaintBrush<Water> brush=WaterContainer.getWaterBrush();
		Water w=brush.getObj();
		w.color();
	}
}

class PaintContainer{
	public static GoodPaintBrush<Paint> getPaintBrush() throws Exception{
		GoodPaintBrush<Paint> brush=new GoodPaintBrush<Paint>();
		Field f=brush.getClass().getDeclaredField("obj");
		f.setAccessible(true);
		ColorInject ci=(ColorInject)f.getAnnotation(ColorInject.class);
		if(ci!=null) {
			String colourclass=ci.colourclass();
			Paint paint=(Paint)Class.forName(colourclass).getConstructor().newInstance();
			brush.obj=paint;
		}
		return brush;
	}
}
class WaterContainer{
	public static GoodPaintBrush<Water> getWaterBrush() throws Exception{
		GoodPaintBrush<Water> brush=new GoodPaintBrush<Water>();
		Field f=brush.getClass().getDeclaredField("obj");
		f.setAccessible(true);
		ColorInject ci=(ColorInject)f.getAnnotation(ColorInject.class);
		if(ci!=null) {
			String colourclass=ci.colourclass();
			Water water=(Water)Class.forName(colourclass).getConstructor().newInstance();
			brush.obj=water;
		}
		return brush;
	}
}

class BadPaintBrush{
	public void doPaint(int i) {
		if(i==1) {
			System.out.println("red paint...");
		}
		else if(i==2) {
			System.out.println("blue paint...");
		}
	}
}
@Retention(RetentionPolicy.RUNTIME)
@interface ColorInject{
	String colourclass();
}
class GoodPaintBrush<T>{
	@ColorInject(colourclass="mindGym.BlueHoliWater")
	T obj;
	public void setT(T obj) {
		this.obj=obj;
	}
	public T getObj() {
		return this.obj;
	}
	
}
abstract class Paint{
	abstract void color();
}
class BluePaint extends Paint{
	public BluePaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	void color() {
		System.out.println("blue color...");
	}
}
class RedPaint extends Paint{
	public RedPaint() {
		// TODO Auto-generated constructor stub
	}
	@Override
	void color() {
		System.out.println("red color...");
	}
}

abstract class Water{
	public abstract void color();
}
class RedHoliWater extends Water{
	public RedHoliWater() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void color() {
		System.out.println("red water....");
	}
}
class BlueHoliWater extends Water{
	public BlueHoliWater() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void color() {
		System.out.println("blue water....");
	}
}