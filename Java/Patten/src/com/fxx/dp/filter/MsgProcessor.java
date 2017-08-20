package com.fxx.dp.filter;

public class MsgProcessor {
	

	private String msg;
	FilterChain fc;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	public FilterChain getFc() {
		return fc;
	}

	public void setFc(FilterChain fc) {
		this.fc = fc;
	}
	public String process(){
		String r =msg;
		r=fc.doFilter(r);
		return r;
	}
}
