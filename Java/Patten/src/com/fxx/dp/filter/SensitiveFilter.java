package com.fxx.dp.filter;

public class SensitiveFilter implements Filter{

	@Override
	public String doFilter(String s) {
		String r= s.replace("����ҵ", "***").replace("����", "**");
		return r;
	}

}
