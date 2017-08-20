package com.fxx.dp.filter;

public class Main {

	public static void main(String[] args) {
		String msg = "大家好：），<script>，敏感，被就业，网络课";
		MsgProcessor mp = new MsgProcessor();
		FilterChain fc = new FilterChain();
		fc.addFilter(new HtmlFilter())
		.addFilter(new SensitiveFilter());
		mp.setMsg(msg);
		mp.setFc(fc);
		String result = mp.process();
		System.out.println(result);
	}

}
