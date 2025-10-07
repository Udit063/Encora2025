package week35;

import java.util.HashMap;
import java.util.Iterator;
// It's a separate interface that doesn't come in any collection
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo3 {
	public static void main(String[] args) {
//		Map<String, String> hm = new HashMap<String, String>();
//		Map<String, String> hm = new TreeMap<String, String>();
//		hm.put("a1", "ramesh");
//		hm.put("a2", "rahul");
//		hm.put("a0", "rohan");
//		System.out.println(hm);
		
		Map<Employee, String> hm = new TreeMap<>((o1,o2)->o2.compareTo(o1));
		hm.put(new Employee("ramu", 30), "ramu");
		hm.put(new Employee("somu", 20), "somu");
		hm.put(new Employee("anand", 40), "anand");
		System.out.println("hm : "+hm);
		
//		System.out.println(hm.get("a1"));
		Set<Map.Entry<Employee, String>> s = hm.entrySet();
		
		Iterator<Map.Entry<Employee, String>> iter = s.iterator();
		while(iter.hasNext()) {
			Map.Entry<Employee, String> me = iter.next();
			System.out.println(me.getKey() + " == " + me.getValue());
		}
	}
}
