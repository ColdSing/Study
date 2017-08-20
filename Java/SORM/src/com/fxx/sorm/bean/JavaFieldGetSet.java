package com.fxx.sorm.bean;
/**
 * 封装了java属性和get set方法的源代码
 * @author 风潇潇
 *
 */
public class JavaFieldGetSet {
	
	/**
	 * 属性源码信息。如：private int userId;
	 */
	private String fieldInfo;
	/**
	 * get方法源码信息。如：public int getUserId(){}
	 */
	private String getInfo;
	/**
	 * get方法源码信息。如：public void setUserId(){}
	 */
	private String setInfo;
	public String getFieldInfo() {
		return fieldInfo;
	}
	public void setFieldInfo(String fieldInfo) {
		this.fieldInfo = fieldInfo;
	}
	public String getGetInfo() {
		return getInfo;
	}
	public void setGetInfo(String getInfo) {
		this.getInfo = getInfo;
	}
	public String getSetInfo() {
		return setInfo;
	}
	public void setSetInfo(String setInfo) {
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(String fieldInfo, String getInfo, String setInfo) {
		this.fieldInfo = fieldInfo;
		this.getInfo = getInfo;
		this.setInfo = setInfo;
	}
	public JavaFieldGetSet(){
		
	}
	@Override
	public String toString() {
		System.out.println(fieldInfo);
		System.out.println(getInfo);
		System.out.println(setInfo);
		return super.toString();
	}
	
}
