package com.fxx.sorm.util;

public class StringUtils {
	/**
	 * ��Ŀ���ַ�������ĸ��ɴ�д
	 * @param tname
	 * @return
	 */
	public static String firstChar2UpperCase(String str) {
		return str.toUpperCase().substring(0,1)+str.substring(1);
	}

}
