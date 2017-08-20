package com.fxx.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo01 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String method = request.getMethod();
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		String contextPath = request.getContextPath();
		String queryString = request.getQueryString();
		System.out.println("method:"+method+" URI:"+requestURI+" URL:"+requestURL+" comtemtPath:"+contextPath+" queryString:"+queryString);
	*/
		String referer = request.getHeader("referer");
		System.out.println(referer);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}