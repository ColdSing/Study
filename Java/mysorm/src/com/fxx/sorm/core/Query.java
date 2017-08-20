package com.fxx.sorm.core;

import java.util.List;

public interface Query {
	public void insert(Object obj);
	
	public void delete(Object obj);
	
	public int update(Object obj);
	
	public Number queryNumber(String sql,Object[] params);
	
	public List queryRows(String sql,Class clazz,Object[] params);
	
	public Object queryUniqueRow(String sql,Class clazz,Object[] params);
	
	public Object queryValue(String sql,Object[] params);
	
	public void delete(Class clazz,Object id);
	
}
