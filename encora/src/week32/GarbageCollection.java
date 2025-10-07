//package week32;
//
//public class GarbageCollection {
//	public static void main(String[] args) {
//		Runtime rt = Runtime.getRuntime();
//		System.out.println("Memory before dadduu....: " + rt.freeMemory());
//		GrandFather daddu = new GrandFather();
//		System.out.println("Memory after dadduu....: " + rt.freeMemory());
//		// gc -> garbage collection
//		
//		daddu = null;
//		System.out.println("Memory after dadduu death....: " + rt.freeMemory());
//
//		rt.gc();
//		System.out.println("Memory after dadduu kriyakaram....: " + rt.freeMemory());
//
//	}
//}
//
///*
// * Serial gc -> Single thread. ex, 1 kanta bai for whole ofc
// * We have bifercation in jeevan gc but not in parallel gc. ex, parallel gc -> 4-5 kanta bai for the ofc, jeevan gc -> take up space that required and only that space is needed for cleaning.
// * If a big ofc is there with same situation then it's cgc and for moderate its jeevan gc
// */
//
//class GrandFather{
//	String age;
//	public GrandFather() {
//		for(int i=0; i<1000;i++) {
////			on using new, it creates up 2 spaces, one in stack and one in heap
//			age = new String(" " + i);
//		}
//	}
//}

package week32;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
//-XX:+UseParallelGC
public class GarbageCollection {
	public static void main(String[] args) {
		Runtime rt=Runtime.getRuntime();
		System.out.println("Memory before daddu..:"+rt.freeMemory());
		GrandFather daddu=new GrandFather();
		System.out.println("Memory after daddu...:"+rt.freeMemory());
		SoftReference<GrandFather> soft=new SoftReference<>(daddu);
//		WeakReference<GrandFather> weakref=new WeakReference<>(daddu);
		daddu=null;
		System.out.println("After daddus death...:"+rt.freeMemory());
		System.gc();
		System.out.println("After daddus kriyakaram...:"+rt.freeMemory());
		//System.out.println("daddu comes back....");
		//daddu=soft.get();
		//System.out.println(daddu);
	}
}
class GrandFather{
	String age;
	private String gold="under the tree....";
	public GrandFather() {
		for(int i=0;i<10000;i++) {
			age=new String(".."+i);
		}
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("the gold is...:"+gold);
	}
}




