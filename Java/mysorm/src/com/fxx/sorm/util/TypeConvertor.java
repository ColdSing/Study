package com.fxx.sorm.util;
/**
 * 将数据库数据类型同Java数据类型相互转换
 * @author 风潇潇
 *
 */
public interface TypeConvertor {
	/**
	 * 将数据库数据类型转换为Java数据类型
	 * @param columnType 数据库数据类型
	 * @returnJava数据类型
	 */
	public String databaseType2JavaType(String columnType);
	/**
	 * 将Java数据类型转换为数据库数据类型
	 * @param javaDataTypeJava数据类型
	 * @return数据库数据类型
	 */
	public String javaType2DatabaseType(String javaDataType);

}
