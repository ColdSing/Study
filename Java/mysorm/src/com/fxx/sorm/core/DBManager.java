package com.fxx.sorm.core;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.fxx.sorm.bean.Configeration;

public class DBManager {
	private static Configeration conf = new Configeration();
	static{
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
			conf.setDriver(pros.getProperty("driver"));
			conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
			conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
			conf.setPoPackage(pros.getProperty("poPackage"));
			conf.setPwd(pros.getProperty("pwd"));
			conf.setQueryClass(pros.getProperty("queryClass"));
			conf.setSrcPath(pros.getProperty("srcPath"));
			conf.setUrl(pros.getProperty("url"));
			conf.setUser(pros.getProperty("user"));
			conf.setUsingDB(pros.getProperty("usingDB"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		try {
			Class.forName(conf.getDriver());
			Connection conn = DriverManager.getConnection(conf.getUrl(), conf.getUser(), conf.getPwd());
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement ps,Connection conn){
		
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
public static void close(Connection conn){
		try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Configeration getConf() {
		return conf;
	}
	
	
}
