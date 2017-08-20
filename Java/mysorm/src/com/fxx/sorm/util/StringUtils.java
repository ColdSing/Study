package com.fxx.sorm.util;

public class StringUtils {
	public static String first2Uppercase(String str){
		String s=str.toUpperCase().substring(0, 1)+str.substring(1);
		return s;
	}
}
