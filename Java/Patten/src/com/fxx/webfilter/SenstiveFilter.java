package com.fxx.webfilter;

public class SenstiveFilter implements Filter{
	@Override
	public void doFilter(Response rep, Request req, FilterChain chain) {
		req.setRequestStr(req.getRequestStr().replace("被就业", "***").replace("敏感", "**")+"---Senstive---");
		chain.doFilter(rep, req, chain);
		rep.setResponseStr(rep.getResponseStr()+"---Senstive---");
	}

}
