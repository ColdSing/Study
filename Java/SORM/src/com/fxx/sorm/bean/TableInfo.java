package com.fxx.sorm.bean;

import java.util.List;
import java.util.Map;

/**
 * 存储表的结构
 * @author 风潇潇
 *
 */
public class TableInfo {
	

	/**
	 * 表名
	 */
	private String tname;
	/**
	 * 所有字段信息
	 */
	private Map<String ,ColumnInfo> columns;
	
	/**
	 * 唯一主键
	 */
	private ColumnInfo onlyPriKey;
	
	/**
	 * 处理可能联合主键的情况
	 */
	private List<ColumnInfo> priKeys;
	
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}

	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}

	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}

	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}

	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}

	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}

	public TableInfo() {
	}

	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey) {
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
	}

	public TableInfo(String tname,List<ColumnInfo> priKeys, Map<String, ColumnInfo> columns) {
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}
	
	
	
}
