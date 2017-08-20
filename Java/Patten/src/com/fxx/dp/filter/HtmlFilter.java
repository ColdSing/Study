package com.fxx.dp.filter;

public class HtmlFilter implements Filter {

	@Override
	public  String doFilter(String s) {
		String r= s.replace('<', '[').replace('>',']');
		return r;
	}

}
