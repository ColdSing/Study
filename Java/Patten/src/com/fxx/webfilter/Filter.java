package com.fxx.webfilter;

public interface Filter {
	void doFilter(Response rep,Request req,FilterChain chain);
}
