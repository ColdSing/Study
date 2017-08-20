package com.fxx.webfilter;

public class HtmlFilter implements Filter{
	@Override
	public void doFilter(Response rep, Request req, FilterChain chain) {
		req.setRequestStr(req.getRequestStr().replace('<', '[').replace('>',']')+"---Html---");
		chain.doFilter(rep, req, chain);
		rep.setResponseStr(rep.getResponseStr()+"---Html---");
	}

}
