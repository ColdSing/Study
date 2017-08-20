package com.fxx.xml.dom4j;

public class MyServlet1 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("init1");
	}

	@Override
	public void action() {
		System.out.println("action1");
	}

	@Override
	public void end() {
		System.out.println("end1");
	}

}
