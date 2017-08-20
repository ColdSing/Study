package com.fxx.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	//新建连接池
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//新建ThreadLocal用于存储Connection
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	//获取当前线程存储的Connection，若不存在则从池中取出一个放入线程ThreadLocal
	public static Connection getCurrentConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn==null) {
			conn=dataSource.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	//提交事务，去除连接，返还连接
	public static void commit() throws SQLException {
		Connection conn= getCurrentConnection();
		conn.commit();
		tl.remove();
		if(conn!=null) {
			conn.close();
		}
	}
	//事务回滚
	public static void rollback() throws SQLException {
		Connection conn= getCurrentConnection();
		conn.rollback();
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
		
	}

}
