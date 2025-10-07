package realinterfacepack;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Mixing implements InvocationHandler{
	Object obj[];
	public Mixing(Object obj[]) {
		this.obj=obj;
	}
@Override
public Object invoke(Object proxy, Method method, Object[] args)
		throws Throwable {
	Object o=null;
	//System.out.println("invoke method of mixing called..."+proxy.getClass().getName());
	//System.out.println(obj.length);
	for(int i=0;i<obj.length;i++){
		Method m[]=proxy.getClass().getDeclaredMethods();
		for(int j=0;j<m.length;j++){
			//m[j].setAccessible(true);
			//System.out.println(m[j].getName());
		}
		try{ o=method.invoke(obj[i],args);}catch(Exception e){};//{System.out.println(e);}
	}
	return o;
}
}

