package week35;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ColDemo1 {
	public static void main(String[] args) {
		Set<String> myset = new HashSet<String>();  // no need to give String on RHS, you can simply give diamond also
		// No matter in what sequence you add, it will always give in sorted order
		// Repeated values will not get added
		myset.add("ddd");
		myset.add("bbb");
		myset.add("aaa");
		myset.add("zzz");
		myset.add("zzz");
		
		System.out.println(myset);
		
		// Iterator can be used only once
		Iterator<String> iter = myset.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		System.out.println();
		myset.forEach(System.out::println);
		System.out.println();
		for(String s:myset) {
			System.out.println(s);
		}
		
		System.out.println();
		myset.stream().parallel().forEachOrdered(System.out::println);
	}
}
