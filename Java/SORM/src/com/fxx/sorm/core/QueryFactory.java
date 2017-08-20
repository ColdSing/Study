package com.fxx.sorm.core;

public class QueryFactory {
	private static QueryFactory factory = new QueryFactory();
	private static Query prototypeObj;
	static{
		try {
			Class c = Class.forName(DBManager.getConf().getQueryClass());
			prototypeObj = (Query)c.newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	private QueryFactory(){
	}
	
	public static Query createQuery(){
		try {
			return (Query) prototypeObj.clone();
		} catch ( CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
}
