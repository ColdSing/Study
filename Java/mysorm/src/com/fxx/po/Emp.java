package com.fxx.po;

import java.util.*;
import java.lang.*;

public class Emp{
	private java.sql.Date birthday;
	private Double bonus;
	private String name;
	private Integer deptid;
	private Integer id;
	private java.sql.Blob pic;
	private Double salary;
	public void setBirthday(java.sql.Date birthday){
		this.birthday=birthday;
	}
	public java.sql.Date getBirthday(){
		return this.birthday;
	}

	public void setBonus(Double bonus){
		this.bonus=bonus;
	}
	public Double getBonus(){
		return this.bonus;
	}

	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}

	public void setDeptid(Integer deptid){
		this.deptid=deptid;
	}
	public Integer getDeptid(){
		return this.deptid;
	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return this.id;
	}

	public void setPic(java.sql.Blob pic){
		this.pic=pic;
	}
	public java.sql.Blob getPic(){
		return this.pic;
	}

	public void setSalary(Double salary){
		this.salary=salary;
	}
	public Double getSalary(){
		return this.salary;
	}

}