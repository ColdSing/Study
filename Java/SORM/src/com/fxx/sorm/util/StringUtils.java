package com.fxx.sorm.util;

public class StringUtils {
	/**
	 * 将目标字符串首字母变成大写
	 * @param tname
	 * @return
	 */
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0,1)+str.substring(1);
	}

}
