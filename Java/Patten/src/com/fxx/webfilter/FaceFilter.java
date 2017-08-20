package com.fxx.webfilter;

public class FaceFilter implements Filter{
	@Override
	public void doFilter(Response rep, Request req, FilterChain chain) {
		req.setRequestStr(req.getRequestStr().replace(":)", "^-^")+"---Face---");
		chain.doFilter(rep, req, chain);
		rep.setResponseStr(rep.getResponseStr()+"---Face---");
	}

}
