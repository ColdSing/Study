package queen;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack<E> {
	private Deque<E> myStack = new ArrayDeque<E>();
	private int cap;
	public MyStack(int cap) {
		this.cap = cap;
	}
	public boolean push(E e){
		if(myStack.size()==cap){
			try {
				throw new Exception();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		myStack.addLast(e);
		return true;
	}
	
	public E peek(){
		return myStack.peekLast();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
