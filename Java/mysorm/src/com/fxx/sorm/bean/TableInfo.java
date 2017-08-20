package com.fxx.sorm.bean;

import java.util.List;
import java.util.Map;

public class TableInfo {
	
	private String tname;
	private Map<String,ColumnInfo> columns;
	private ColumnInfo priKey;
	private List<ColumnInfo> priKeys;
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo priKey) {
		this.tname = tname;
		this.columns = columns;
		this.priKey = priKey;
	}
	public TableInfo(String tname, Map<String, ColumnInfo> columns, List<ColumnInfo> priKeys) {
		this.tname = tname;
		this.columns = columns;
		this.priKeys = priKeys;
	}
	public TableInfo() {
	}
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
	public ColumnInfo getPriKey() {
		return priKey;
	}
	public void setPriKey(ColumnInfo priKey) {
		this.priKey = priKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
}
