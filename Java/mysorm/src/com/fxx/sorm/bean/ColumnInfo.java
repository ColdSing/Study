package com.fxx.sorm.bean;

public class ColumnInfo {
	private String name;
	private String type;
	private boolean isPriKey;
	
	public ColumnInfo(String name, String type, boolean isPriKey) {
		this.name = name;
		this.type = type;
		this.isPriKey = isPriKey;
	}
	public ColumnInfo(){}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isPriKey() {
		return isPriKey;
	}
	public void setPriKey(boolean isPriKey) {
		this.isPriKey = isPriKey;
	}
	
}
