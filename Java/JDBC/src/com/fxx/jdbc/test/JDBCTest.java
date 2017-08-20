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
	 * δʹ�����ӳأ�ֱ�ӽ�����ر�����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	
	public void login() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			//1.��������
			Class.forName("com.mysql.jdbc.Driver");
			//2.��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sorm", "root", "626115@Lm");
			stmt = conn.createStatement();
			//4.����sql���
			String sql ="select * from emp where empno>2";
			rs = stmt.executeQuery(sql);
			//6.�����ѯ���
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
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
	 * ʹ�ù�����������ӵĻ�ȡ��رգ�δʹ�����ӳ�
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
			//4.����sql���
			String sql ="select * from emp where empno=1001";
			rs = stmt.executeQuery(sql);
			//6.�����ѯ���
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	
	
	/**
	 * �Զ������ӳأ���ͨ��װ��ģʽ��ǿConnection��close���ܣ�ֱ�ӷ��ػ����ӳ�
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
			//3.������ִ����
			stmt = conn.createStatement();
			//4.����sql���
			String sql ="select * from emp where empno=1001";
			//5.ִ��sql���
			rs = stmt.executeQuery(sql);
			//6.�����ѯ���
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	
	/**
	 * ʹ��C3P0�������ӳ�
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void login3() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = C3P0DataSource.getConnection();
			//3.������ִ����
			stmt = conn.createStatement();
			//4.����sql���
			String sql ="select * from emp where empno=1001";
			//5.ִ��sql���
			rs = stmt.executeQuery(sql);
			//6.�����ѯ���
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	/**
	 * ʹ��DBCP���ӳ�
	 */
	public void login4() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			conn = DBCPDataSource.getConnection();
			//3.������ִ����
			stmt = conn.createStatement();
			//4.����sql���
			String sql ="select * from emp where empno=1001";
			//5.ִ��sql���
			rs = stmt.executeQuery(sql);
			//6.�����ѯ���
			while(rs.next()){
				String name=rs.getString("ename");
				System.out.println(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//7.�ͷ���Դ
			JDBCUtil_V1.rlease(rs,stmt,conn);
		}
		
	}
	/**
	 * ʹ��DBUtilsִ���޸�
	 */
	public void update() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.����sql���
			String sql ="update emp set ename=? where empno=?";
			Object[] params ={"����",1001};
			//5.ִ��sql���
			qr.update(sql, params);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * ʹ��DBUtilsɾ������
	 */
	public void delete() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.����sql���
			String sql ="delete from emp where empno=?";
			Object[] params ={1001};
			//5.ִ��sql���
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ��DBUtils�������
	 */
	public void add() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.����sql���
			String sql ="insert into emp (empno,ename) values(?,?)";
			Object[] params ={1001,"����"};
			//5.ִ��sql���
			qr.update(sql, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ʹ��DBUtils��ѯ
	 * ʹ��BeanListHandler���ܽ����
	 * 
	 * 
	 */
	public void query1() {
		try {
			QueryRunner qr=new QueryRunner(C3P0DataSource.getDataSource());
			//4.����sql���
			String sql ="select * from dept";
			ResultSetHandler<List<Dept>> rsh= new BeanListHandler<Dept>(Dept.class);
			//5.ִ��sql���
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
			//4.����sql���
			String sql ="select sum(deptno) from dept";
			ResultSetHandler rsh= new ScalarHandler();
			//5.ִ��sql���
			BigDecimal sum= (BigDecimal) qr.query(sql, rsh);
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
