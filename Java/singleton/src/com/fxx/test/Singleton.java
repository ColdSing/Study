package com.fxx.test;

import java.util.concurrent.CountDownLatch;

/**
 * ∂ˆ∫∫ Ω
 * @author ∑Á‰Ï‰Ï
 *
 */
public class Singleton {
	private Singleton() {
	}
	private static Singleton instance = new Singleton();
	public static Singleton getIstance(){
		return instance;
	}
	public static void main(String[] args) throws InterruptedException {
		Long start = System.currentTimeMillis();
		int numOfThread =10;
		final CountDownLatch cdl = new CountDownLatch(numOfThread);
		for(int i=0;i<numOfThread;i++){
			new Thread(new Runnable(){
				@Override
				public void run() {
					for(int i=0;i<10000;i++){
						Singleton sl = Singleton.getIstance();
					}
					cdl.countDown();
				}
				
			}).start();
		}
		cdl.await();
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
/**
 *¿¡∫∫ Ω 
 * 
*/

class Singleton1{
	private Singleton1() {
	}
	private static Singleton1 instance;
	public static synchronized Singleton1 getIstance(){
		if(instance ==null){
			instance = new Singleton1();
		}
		return instance;
	}
}

class Singleton2{
	private Singleton2() {
	}
	private static class SingletonInstance{
		static Singleton2 instance = new Singleton2(); 
	}
	public Singleton2 getIstance(){
		return SingletonInstance.instance;
	}
}


enum Singleton3{
	INSTANCE;
}
