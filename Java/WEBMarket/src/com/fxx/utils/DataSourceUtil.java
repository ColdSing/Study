package com.fxx.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtil {
	//�½����ӳ�
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	//�½�ThreadLocal���ڴ洢Connection
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	//��ȡ��ǰ�̴߳洢��Connection������������ӳ���ȡ��һ�������߳�ThreadLocal
	public static Connection getCurrentConnection() throws SQLException{
		Connection conn = tl.get();
		if(conn==null) {
			conn=dataSource.getConnection();
			tl.set(conn);
		}
		return conn;
	}
	//�ύ����ȥ�����ӣ���������
	public static void commit() throws SQLException {
		Connection conn= getCurrentConnection();
		conn.commit();
		tl.remove();
		if(conn!=null) {
			conn.close();
		}
	}
	//����ع�
	public static void rollback() throws SQLException {
		Connection conn= getCurrentConnection();
		conn.rollback();
	}
	
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
		
	}

}
