package com.fxx.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPDataSource {
	private static DataSource dataSource;
	static{
		try {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties pros = new Properties();
			pros.load(is);
			try {
				dataSource=BasicDataSourceFactory.createDataSource(pros);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
