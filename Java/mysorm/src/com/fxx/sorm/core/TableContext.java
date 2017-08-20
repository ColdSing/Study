package com.fxx.sorm.core;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fxx.sorm.bean.ColumnInfo;
import com.fxx.sorm.bean.TableInfo;
import com.fxx.sorm.util.JavaFileUtils;
import com.fxx.sorm.util.MySqlTypeConvertor;
import com.fxx.sorm.util.StringUtils;

public class TableContext {
	private static Map<String,TableInfo> tables = new HashMap<String,TableInfo>();
	private static Map<Class,TableInfo> tableClass=new HashMap<Class,TableInfo>();
	public  TableContext(){}
	static{
		Connection conn =null;
		try {	
			conn = DBManager.getConnection();
			DatabaseMetaData dmd=conn.getMetaData();
			ResultSet tableRet = dmd.getTables(null, "%","%",new String[]{"TABLE"}); 
			
			while(tableRet.next()){
				String tableName = (String) tableRet.getObject("TABLE_NAME");
				
				TableInfo ti = new TableInfo(tableName,new HashMap<String, ColumnInfo>(),new ArrayList<ColumnInfo>());
				tables.put(tableName, ti);
				
				ResultSet set = dmd.getColumns(null, "%", tableName, "%");  //查询表中的所有字段
				while(set.next()){
					ColumnInfo ci = new ColumnInfo(set.getString("COLUMN_NAME"), 
							set.getString("TYPE_NAME"), false);
					ti.getColumns().put(set.getString("COLUMN_NAME"), ci);
				}
				
				ResultSet set2 = dmd.getPrimaryKeys(null, "%", tableName);  //查询t_user表中的主键
				while(set2.next()){
					ColumnInfo ci2 = (ColumnInfo) ti.getColumns().get(set2.getObject("COLUMN_NAME"));
					ci2.setPriKey(true);  //设置为主键类型
					ti.getPriKeys().add(ci2);
				}
				
				if(ti.getPriKeys().size()>0){  //取唯一主键。。方便使用。如果是联合主键。则为空！
					ti.setPriKey(ti.getPriKeys().get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn);
		}
		updateJavaPOFile();
		
		loadPOFile();
		
	}
	
	public static void updateJavaPOFile(){
		for(TableInfo tif:TableContext.getTables().values()){
			JavaFileUtils.creatPOFiles(tif, new MySqlTypeConvertor());
		}
	}
	
	public static void loadPOFile(){
		try {
			Set<Entry<String, TableInfo>> tablesSet = tables.entrySet();
			Iterator<Entry<String, TableInfo>> itr = tablesSet.iterator();
			while(itr.hasNext()){
				Entry<String, TableInfo> en =itr.next();
				String s=en.getKey();
				TableInfo tif = en.getValue();
				Class c=Class.forName(DBManager.getConf().getPoPackage()+"."+StringUtils.first2Uppercase(s));
				tableClass.put(c, tif);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("need refresh com.fxx.po");
		}
		
	}
	
	public static Map<String, TableInfo> getTables() {
		return tables;
	}
	public static void setTables(Map<String, TableInfo> tables) {
		TableContext.tables = tables;
	}
	public static Map<Class, TableInfo> getTableClass() {
		return tableClass;
	}
	public static void setTableClass(Map<Class, TableInfo> tableClass) {
		TableContext.tableClass = tableClass;
	}
	public static void main(String[] args) {
		TableContext tc = new TableContext();
		for(Object c:tc.getTableClass().keySet().toArray()){
			System.out.println(c);
		}
	}
}
