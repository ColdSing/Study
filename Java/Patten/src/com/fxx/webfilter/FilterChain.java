package com.fxx.webfilter;

import java.util.ArrayList;
import java.util.List;


public class FilterChain implements Filter{
	private List <Filter> filters = new ArrayList<Filter>();
	private int index=0;
	public FilterChain addFilter(Filter f){
		filters.add(f);
		return this;
	}
	
	@Override
	public void doFilter(Response rep, Request req,FilterChain chain) {
		if(index==filters.size()){
			return;
		}
		Filter f= filters.get(index);
		index++;
		f.doFilter(rep, req, chain);
	}

}
