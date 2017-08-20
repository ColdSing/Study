package com.fxx.po;

import java.sql.*;
import java.util.*;

public class Emp {

	private java.sql.Date birthday;
	private Double bonus;
	private String name;
	private Integer deptid;
	private Integer id;
	private java.sql.Blob pic;
	private Double salary;



	public java.sql.Date getBirthday(){
		return birthday;
	}
	public void setBirthday(java.sql.Date birthday){
		this.birthday=birthday;
	}
	public Double getBonus(){
		return bonus;
	}
	public void setBonus(Double bonus){
		this.bonus=bonus;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Integer getDeptid(){
		return deptid;
	}
	public void setDeptid(Integer deptid){
		this.deptid=deptid;
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public java.sql.Blob getPic(){
		return pic;
	}
	public void setPic(java.sql.Blob pic){
		this.pic=pic;
	}
	public Double getSalary(){
		return salary;
	}
	public void setSalary(Double salary){
		this.salary=salary;
	}
}