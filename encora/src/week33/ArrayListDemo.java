package week33;

/*
 * Comparable is used for sorting -> it uses the compareTo method, it takes up 2 String - String o1, String o2.
 * If they are equal, then it returns true otherwise false 
 * For asc -> o1.compareTo(o2) and desc -> o2.compareTo(o1)
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> list=new Vector<>();
		list.add("Zambia");
		list.add("America");
		list.add("India");
		list.add("Bhutan");
		//list.add(new Employee());
		
		for(String o:list) {
			System.out.println(o);
		}
		System.out.println(list.get(0));
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		//Iterator
		Iterator<String> iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		ListIterator<String> liter=list.listIterator();
		while(liter.hasNext()) {
			System.out.println(liter.next());
		}
		while(liter.hasPrevious()) {
			System.out.println(liter.previous());
		}
		System.out.println();
		list.sort(new MyComparator());
		//Collections.sort(new );
		System.out.println(list);
	}
}
class MyComparator implements Comparator<String>{
	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		//System.out.println("called");
		return o1.compareTo(o2);
	}
}
class Employee{}

