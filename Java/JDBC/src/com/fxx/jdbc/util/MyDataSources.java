package com.fxx.jdbc.util;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;


public class MyDataSources implements DataSource{
	
	private List<Connection> pool = new LinkedList<Connection>();
	
	public MyDataSources() {
		if(pool.size()==0){
			for(int i=0;i<5;i++){
				Connection conn = new MyConnection(this);
				pool.add(conn);
			}
		}
	}
	
	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		Connection conn=null;
		if(pool.size()==0){
			for(int i=0;i<5;i++){
				conn = new MyConnection(this);
				pool.add(conn);
			}	
		}
		conn=pool.remove(0);
		return conn;
	}
	
	public void backConnection(Connection conn){
		if(conn!=null){
			pool.add(conn);
		}
	}

	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



	

}
