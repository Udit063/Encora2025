package week35;

import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropDemo5 {
	public static void main(String[] args)throws Exception {
		// Properties class doesn't have genrics --> kuch bhi daalo chl jayega
		Properties prop = new Properties();
		// prop.put(new Employee("ramu",20), "ramu");
//		System.out.println(prop);
		
		// This is used to read files from the file path - from my project folder
//		 prop.load(new FileInputStream("dictionary.properties"));
		
		Locale locale = new Locale("hi");
		Locale.setDefault(locale);
		
		// This is used to read files from class path - from src folder		ResourceBundle rb = ResourceBundle.getBundle("mydictionary");
		ResourceBundle rb = ResourceBundle.getBundle("mydictionary");
		System.out.println(rb.getString("hello"));
		
		
		 System.out.println(prop.get("hello"));
	}
}
