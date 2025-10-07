package week35;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class WeakMapDemo4 {
	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> map = new WeakHashMap<String, String>();

		
		String key1 = new String("key1");
		String key2 = new String("key2");

		map.put(key1, "India");
		map.put(key2, "america");
		System.out.println(map);
		
		key1=null;
		System.gc();
		System.out.println(map);
	}
}
