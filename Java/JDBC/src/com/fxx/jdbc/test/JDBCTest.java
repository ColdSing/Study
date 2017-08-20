package com.fxx.jdbc.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.fxx.jdbc.domain.Dept;
import com.fxx.jdbc.util.C3P0DataSource;
import com.fxx.jdbc.util.DBCPDataSource;
import com.fxx.jdbc.util.JDBCUtil_V1;
import com.fxx.jdbc.util.MyDataSources;

public class JDBCTest {
	@Test
	public void logintest(){
		long start = System.currentTimeMillis();
		//MyDataSources md = new MyDataSources();
		for(int i=0;i<10000;i++){
			login4();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
	@Test
	public void updateTest(){
		add();
	}
	
	@Test
	public void queryTest(){
		query2();
	}
	/**
	 * 未使用连接池，直接建立与关闭连接
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void login() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1.加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm", "root", "626115@Lm");
			stmt = conn.createStatement();
			//4.建立sql语句
			String sql ="select * from emp where empno>2";
			rs = stmt.executeQuery(sql);
			//6.输出查询结果
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			try {
				if(rs!=null){rs.close();}
				if(stmt!=null){stmt.close();}
				if(conn!=null){conn.close();}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 使用工具类进行连接的获取与关闭，未使用连接池
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void login1(){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = JDBCUtil_V1.getConnection();
			stmt = conn.createStatement();
			//4.建立sql语句
			String sql ="select * from emp where empno=1001";
			rs = stmt.executeQuery(sql);
			//6.输出查询结果
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	
	
	/**
	 * 自定义连接池，并通过装饰模式增强Connection的close功能，直接返回会连接池
	 * @param md
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void login2(MyDataSources md){
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = md.getConnection();
			//3.获得语句执行者
			stmt = conn.createStatement();
			//4.建立sql语句
			String sql ="select * from emp where empno=1001";
			//5.执行sql语句
			rs = stmt.executeQuery(sql);
			//6.输出查询结果
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	
	/**
	 * 使用C3P0建立连接池
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void login3() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = C3P0DataSource.getConnection();
			//3.获得语句执行者
			stmt = conn.createStatement();
			//4.建立sql语句
			String sql ="select * from emp where empno=1001";
			//5.执行sql语句
			rs = stmt.executeQuery(sql);
			//6.输出查询结果
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	/**
	 * 使用DBCP连接池
	 */
	public void login4() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = DBCPDataSource.getConnection();
			//3.获得语句执行者
			stmt = conn.createStatement();
			//4.建立sql语句
			String sql ="select * from emp where empno=1001";
			//5.执行sql语句
			rs = stmt.executeQuery(sql);
			//6.输出查询结果
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.释放资源
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	/**
	 * 使用DBUtils执行修改
	 */
	public void update() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.建立sql语句
			String sql ="update emp set ename=? where empno=?";
			Object[] params ={"潇潇",1001};
			//5.执行sql语句
			qr.update(sql, params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * 使用DBUtils删除操作
	 */
	public void delete() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.建立sql语句
			String sql ="delete from emp where empno=?";
			Object[] params ={1001};
			//5.执行sql语句
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 使用DBUtils插入操作
	 */
	public void add() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.建立sql语句
			String sql ="insert into emp (empno,ename) values(?,?)";
			Object[] params ={1001,"潇潇"};
			//5.执行sql语句
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 使用DBUtils查询
	 * 使用BeanListHandler接受结果集
	 * 
	 * 
	 */
	public void query1() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.建立sql语句
			String sql ="select * from dept";
			ResultSetHandler<List<Dept>> rsh= new BeanListHandler<Dept>(Dept.class);
			//5.执行sql语句
			List<Dept> depts=qr.query(sql, rsh);
			for(Dept d:depts){
				System.out.println(d.getDeptno()+"..."+d.getDname()+"..."+d.getLoc());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void query2() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.建立sql语句
			String sql ="select sum(deptno) from dept";
			ResultSetHandler rsh= new ScalarHandler();
			//5.执行sql语句
			BigDecimal sum= (BigDecimal) qr.query(sql, rsh);
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
