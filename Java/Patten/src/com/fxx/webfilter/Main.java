package com.fxx.webfilter;

public class Main {
	public static void main(String[] args) {
		String msg = "大家好:)，<script>，敏感，被就业，网络课";
		Request req = new Request();
		Response rep = new Response();
		req.setRequestStr(msg);
		rep.setResponseStr("response:");
		FilterChain fc= new FilterChain();
		fc.addFilter(new HtmlFilter());
		fc.addFilter(new SenstiveFilter());
		fc.addFilter(new FaceFilter());
		fc.doFilter(rep, req, fc);
		System.out.println(req.getRequestStr());
		System.out.println(rep.getResponseStr());
	}
	
}
