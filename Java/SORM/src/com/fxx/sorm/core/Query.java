package com.fxx.sorm.core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fxx.sorm.bean.ColumnInfo;
import com.fxx.sorm.bean.TableInfo;
import com.fxx.sorm.util.JDBCUtils;
import com.fxx.sorm.util.ReflectUtils;

/**
 * �����ѯ�����ṩ����ĺ�����
 * @author ������
 *
 */

@SuppressWarnings("all")
public abstract class Query implements Cloneable{
	/**
	 * ģ�巽��ģʽ
	 * @param sql ��ѯ���
	 * @param clazz ���ض�������
	 * @param params sql����
	 * @param qcb �ص��ӿ�
	 * @return ��ѯ���
	 */
	public Object excutQueryTemplate(String sql,Class clazz,Object[] params,QueryCallback qcb){
		Connection conn = DBManager.getConn();
		PreparedStatement ps = null;
		ResultSet rs=null;
		Object obj=null;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handlerParams(ps, params);
			System.out.println(ps.toString());
			rs=ps.executeQuery();
			obj = qcb.doExcute(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(rs,ps,conn);
		}
		return obj;
	}
	/**
	 * ֱ��ִ��һ��DML���
	 * @param sql
	 * @param params
	 * @return ִ��sql����Ӱ���¼������
	 */
	public int excuteDML(String sql,Object[] params){
		Connection conn = DBManager.getConn();
		PreparedStatement ps = null;
		int count = 0;
		try {
			ps = conn.prepareStatement(sql);
			JDBCUtils.handlerParams(ps, params);
			count = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBManager.close(ps, conn);
		}
		return count;
	}
	/**
	 * ��һ������洢�����ݿ���
	 * @param obj Ҫ�洢�Ķ���
	 */
	public void insert(Object obj){
		Class clazz= obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		List<Object>temp = new ArrayList<Object>();
		int i =0;
		StringBuilder sqlsb =new StringBuilder("insert into ");
		sqlsb.append(tableInfo.getTname());
		sqlsb.append("(");
		for(ColumnInfo ci: tableInfo.getColumns().values()){
				if(ReflectUtils.invokeGet(ci.getName(), obj)!=null){
				temp.add(ReflectUtils.invokeGet(ci.getName(), obj));
				if(i==0){
					sqlsb.append(ci.getName());
				}else{
					sqlsb.append(","+ci.getName());
				}
				i++;
			}
		}
		Object[] KeyValues = temp.toArray();
		sqlsb.append(")values(");
		for(int j=0;j<i;j++){
			if(j==0){
				sqlsb.append("?");
			}else{
				sqlsb.append(",?");
			}
		}
		sqlsb.append(")");
		System.out.println(sqlsb.toString());
		excuteDML(sqlsb.toString(),KeyValues);
	}
	/**
	 * ɾ��clazz ��ʾ���Ӧ�ı��еļ�¼��ָ������id�ļ�¼��
	 * @param clazz 
	 * @param id
	 * @return
	 */
	public void delete(Class clazz,Object id){
		//delete from User where id=2;
		// Emp.class ,2-->delete from emp where id=2
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
				
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
				
		String sql = "delete from "+tableInfo.getTname()+" where "+onlyPriKey.getName()+"=? ";
				
		excuteDML(sql, new Object[]{id});
		
	}
	
	public void delete(Object obj){
		Class clazz= obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		ColumnInfo onlyPriKey = tableInfo.getOnlyPriKey();
		
		Object priKeyValue=ReflectUtils.invokeGet(onlyPriKey.getName(), obj);
		
		delete(clazz,priKeyValue);
	}
	/**
	 * ����obj �޸����ݿ��¼
	 * @param obj  �����޸ĵĶ���
	 * @param fieldNames ��Ҫ�޸ĵ�������
	 * @return
	 */
	public int update(Object obj,String[] fieldNames){
		
		int count =0;
		Class clazz= obj.getClass();
		TableInfo tableInfo = TableContext.poClassTableMap.get(clazz);
		Object PriKeyValues =ReflectUtils.invokeGet(tableInfo.getOnlyPriKey().getName(),obj);
		
		List<Object>temp = new ArrayList<Object>();
		StringBuilder sqlsb =new StringBuilder("update ");
		sqlsb.append(tableInfo.getTname());
		sqlsb.append(" set ");
		for(int i=0;i<fieldNames.length;i++){
			temp.add(ReflectUtils.invokeGet(fieldNames[i], obj));
			if(i==0){
				sqlsb.append(fieldNames[i]);
				sqlsb.append("=?");
			}else{
				sqlsb.append(","+fieldNames[i]);
				sqlsb.append("=?");
			}
		}
		Object[] KeyValues = temp.toArray();
		sqlsb.append(" where ");
		sqlsb.append(tableInfo.getOnlyPriKey().getName());
		sqlsb.append("=");
		sqlsb.append(PriKeyValues);
		System.out.println(sqlsb.toString());
		count=excuteDML(sqlsb.toString(),KeyValues);
		return count;
	}
	/**
	 * 
	 * @param sql ��ѯ���
	 * @param params ����
	 * @return ����
	 */
	public Number queryNumber(String sql,Object[] params){
		return (queryValue(sql, params) instanceof Number)?(Number)queryValue(sql, params):null;
	}
	/**
	 * ���в�ѯ
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public List queryRows(String sql,Class clazz,Object[] params){
		List result = (List)excutQueryTemplate(sql, clazz, params, new QueryCallback() {
			@Override
			public Object doExcute(ResultSet rs) {
				List rows =null;
				try {
					ResultSetMetaData metaData=rs.getMetaData();
					while(rs.next()){
						if(rows==null){
							rows = new ArrayList();
						}
						Object instance = clazz.newInstance();
						for(int i=0;i<metaData.getColumnCount();i++){
							ReflectUtils.invokeSet(metaData.getColumnLabel(i+1),instance,rs.getObject(i+1));
						}
						rows.add(instance);
					}
				} catch (InstantiationException | IllegalAccessException | SQLException e) {
					e.printStackTrace();
				}
				return rows;
			}
		});
			
		return result;
	}
	/**
	 * ���в�ѯ
	 * @param sql
	 * @param clazz
	 * @param params
	 * @return
	 */
	public Object queryUniqueRow(String sql,Class clazz,Object[] params){
		List rows =new MySqlQuery().queryRows(sql,clazz,params);
		return (rows!=null&&rows.size()==1)? rows.get(0):null;
	}
	
	public Object queryValue(String sql,Object[] params){
		Object value=excutQueryTemplate(sql, null, params, new QueryCallback() {
			@Override
			public Object doExcute(ResultSet rs) {
				
					Object temp = null;
					try {
						while(rs.next()){
							temp = rs.getObject(1);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return temp;
			}
		});
		return value;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	public abstract Object queryPagenate(int pagNum,int size); 
}
