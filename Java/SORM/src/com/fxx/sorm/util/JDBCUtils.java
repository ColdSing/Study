package com.fxx.sorm.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 封装JDBC常用操作
 * @author 风潇潇
 *
 */
public class JDBCUtils {
	/**
	 * 给sql设参
	 * @param ps 预编译sql语句
	 * @param params 参数
	 */
	public static void handlerParams(PreparedStatement ps,Object[] params){
		if(params!=null){
			for(int i =0;i<params.length;i++){
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
