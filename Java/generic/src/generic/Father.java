package generic;

public abstract class Father<T,T1> {
	T name;
	public abstract void test(T t);
}

class Child1 extends Father<String ,Integer>{
	String t2;
	
	public void test(String t) {
		// TODO Auto-generated method stub
		
	}
	
}
class Child2<T1, T> extends Father<T ,T1>{

	@Override
	public void test(T t) {
		// TODO Auto-generated method stub
		
	}
	
	
}