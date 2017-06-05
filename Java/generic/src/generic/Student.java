 package generic;

public class Student<T1,T2> {
	T1 score;
	T2 name;
	public void test(T1 a){
		
	}
}

class Child1 extends Student<String,Integer>{

	@Override
	public void test(String a) {
		// TODO Auto-generated method stub
	}
	
}

class Child2 extends Student{
	
}