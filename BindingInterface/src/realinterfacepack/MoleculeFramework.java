package realinterfacepack;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MoleculeFramework {
	public static List<Class> v=new ArrayList<Class>();
	public static void setInterface(Class c){
		v.add(c);
	}
	public static Object getObject(Object o[])
	{		
		Class c[]=getInterfaces();
		Object object=Proxy.newProxyInstance
		(Human.class.getClassLoader(),c,new Mixing(o));
		return object;
	}
	public static Class[] getInterfaces()
	{
		int i=0;
		int size=v.size();
		Class c[]=new Class[size];
		Iterator<Class> en=v.iterator();
		while(en.hasNext())
		{
			c[i++]=en.next();
		}
		return c;
	}
}

