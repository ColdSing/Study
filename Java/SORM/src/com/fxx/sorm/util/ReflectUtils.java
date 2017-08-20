package com.fxx.sorm.util;

import java.lang.reflect.Method;
@SuppressWarnings("all")
public class ReflectUtils {
	/**
	 * 
	 * @param clazz
	 * @param filedName
	 * @param obj
	 * @return
	 */
	public static Object invokeGet(String filedName,Object obj){
		try {
			Class clazz = obj.getClass();
			Method m = clazz.getDeclaredMethod("get"+StringUtils.firstChar2UpperCase(filedName),null);
			return m.invoke(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	/**
	 * 
	 * @param columnName
	 * @param obj
	 * @return
	 */
	
	public static void invokeSet(String columnName,Object obj,Object columnValue){
		try {
			Class clazz = obj.getClass();
			if(columnValue!=null){
				Method m = clazz.getMethod("set"+StringUtils.firstChar2UpperCase(columnName),
						columnValue.getClass());
				m.invoke(obj,columnValue);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
