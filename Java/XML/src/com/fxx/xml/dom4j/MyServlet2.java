package com.fxx.xml.dom4j;

public class MyServlet2 implements IMyServlet{

	@Override
	public void init() {
		System.out.println("init2");
	}

	@Override
	public void action() {
		System.out.println("action2");
	}

	@Override
	public void end() {
		System.out.println("end2");
	}

}
