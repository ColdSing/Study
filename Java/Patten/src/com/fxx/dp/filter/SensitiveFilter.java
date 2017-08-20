package com.fxx.dp.filter;

public class SensitiveFilter implements Filter{

	@Override
	public String doFilter(String s) {
		String r= s.replace("被就业", "***").replace("敏感", "**");
		return r;
	}

}
