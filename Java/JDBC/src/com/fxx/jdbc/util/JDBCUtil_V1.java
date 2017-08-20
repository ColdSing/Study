package com.fxx.jdbc.util;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil_V1 {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		/*InputStream is = JDBCUtil_V1.class.getClassLoader().getResourceAsStream("db.properties");
		Properties pros = new Properties();
		try {
			pros.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = pros.getProperty("driver");
		url = pros.getProperty("url");
		user = pros.getProperty("user");
		password = pros.getProperty("pwd");*/
		
		ResourceBundle rb = ResourceBundle.getBundle("db");
		driver = rb.getString("driver");
		url = rb.getString("url");
		user = rb.getString("user");
		password = rb.getString("pwd");
		
		
	}
	
	public static Connection getConnection(){
		Connection conn =null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
		public static void rlease(ResultSet rs, Statement stmt, Connection conn) {
			try {
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
}
