package com.fxx.sorm.bean;
/**
 * ��װ��java���Ժ�get set������Դ����
 * @author ������
 *
 */
public class JavaFieldGetSet {
	
	/**
	 * ����Դ����Ϣ���磺private int userId;
	 */
	private String fieldInfo;
	/**
	 * get����Դ����Ϣ���磺public int getUserId(){}
	 */
	private String getInfo;
	/**
	 * get����Դ����Ϣ���磺public void setUserId(){}
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
