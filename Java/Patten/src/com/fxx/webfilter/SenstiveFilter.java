package com.fxx.webfilter;

public class SenstiveFilter implements Filter{
	@Override
	public void doFilter(Response rep, Request req, FilterChain chain) {
		req.setRequestStr(req.getRequestStr().replace("����ҵ", "***").replace("����", "**")+"---Senstive---");
		chain.doFilter(rep, req, chain);
		rep.setResponseStr(rep.getResponseStr()+"---Senstive---");
	}

}
