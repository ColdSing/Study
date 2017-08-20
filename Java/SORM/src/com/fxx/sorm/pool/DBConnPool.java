package com.fxx.sorm.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fxx.sorm.core.DBManager;

/**
 * ���ӳ���
 * @author ������
 *
 */
public class DBConnPool {
	/**
	 * ���ӳض���
	 */
	private static List<Connection> pool;//���ӳض���
	/**
	 * ���������
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize();
	/**
	 * ��С������
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();
	/**
	 * ��ʼ�����ӳ�,ʹ���ӳ��ڵ����Ӵﵽ��Сֵ
	 */
	public void initPool(){
		if(pool==null){
			pool = new ArrayList<Connection>();
		}
		while(pool.size()<DBConnPool.POOL_MIN_SIZE){
			pool.add(DBManager.creatConn());
		}
	}
	public DBConnPool(){
		initPool();
	}
	/**
	 * �����ӳ���ȡ��һ������
	 * @return
	 */
	public synchronized Connection getConnection(){
		int last_index = pool.size()-1;
		if(last_index>=0){
			Connection conn = pool.get(last_index);
			pool.remove(last_index);
			return conn;
		}else{
			return DBManager.creatConn();
		}
	}
	/**
	 * �����ӷŻس���
	 * @param conn
	 */
	public synchronized void close(Connection conn){
		if(pool.size()>=POOL_MAX_SIZE){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			pool.add(conn);
		}
		
	}
	
	
}
