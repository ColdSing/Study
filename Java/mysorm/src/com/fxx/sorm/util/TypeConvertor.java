package com.fxx.sorm.util;
/**
 * �����ݿ���������ͬJava���������໥ת��
 * @author ������
 *
 */
public interface TypeConvertor {
	/**
	 * �����ݿ���������ת��ΪJava��������
	 * @param columnType ���ݿ���������
	 * @returnJava��������
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * ��Java��������ת��Ϊ���ݿ���������
	 * @param javaDataTypeJava��������
	 * @return���ݿ���������
	 */
	public String javaType2DatabaseType(String javaDataType);

}
