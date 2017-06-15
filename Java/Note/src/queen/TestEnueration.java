package queen;

import java.util.Enumeration;
import java.util.Vector;

public class TestEnueration {
	
	public static void main(String[] args) {
		Vector<String> vec =new Vector<String>();
		vec.add("Java");
		vec.add("c");
		vec.add("c++");
		Enumeration<String> enu = vec.elements();
		while(enu.hasMoreElements()){
			System.out.println(enu.nextElement());
		}
	}
}
