package com.fxx.sorm.core;

import java.util.List;

import com.fxx.sorm.bean.TableInfo;

public class MySqlQuery implements Query{

	@Override
	public void insert(Object obj) {
		Class c =obj.getClass();
		TableInfo tif = TableContext.getTableClass().get(c);
		
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Number queryNumber(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List queryRows(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryUniqueRow(String sql, Class clazz, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object queryValue(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Class clazz, Object id) {
		// TODO Auto-generated method stub
		
	}

}
