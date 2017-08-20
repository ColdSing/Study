package com.fxx.xml.dom4j;

import java.util.HashMap;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class MyServletTest {
	@Test
	public void test(){
		try {
			String url ="/hello1";
			HashMap<String,String> servletMap=getMap();
			String className=servletMap.get(url);
			Class<IMyServlet> clazz = (Class<IMyServlet>) Class.forName(className);
			IMyServlet ms = clazz.newInstance();
			ms.init();
			ms.action();
			ms.end();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HashMap<String,String> getMap(){
		HashMap<String,String> servletMap=new HashMap<String,String>();
		try {
			String servletName="";
			String servletClass="";
			String urlPattern="";
			SAXReader saxReader = new SAXReader();
			Document dom = saxReader.read("src/com/fxx/xml/dtd/web.xml");
			Element rootElement = dom.getRootElement();
			List<Element> elements = rootElement.elements();
			for (Element e : elements) {
				if("servlet".equals(e.getName())){
					servletName = e.element("servlet-name").getText();
					servletClass = e.element("servlet-class").getText();
					servletMap.put(servletName, servletClass);
				}
				if("servlet-mapping".equals(e.getName())){
					servletName = e.element("servlet-name").getText();
					urlPattern = e.element("url-pattern").getText();
					servletMap.put(urlPattern,servletMap.get(servletName));
					servletMap.remove(servletName);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	return servletMap;
	}
}
