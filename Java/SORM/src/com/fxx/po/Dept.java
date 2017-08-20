package com.fxx.po;

import java.sql.*;
import java.util.*;

public class Dept {

	private String adress;
	private Integer id;



	public String getAdress(){
		return adress;
	}
	public void setAdress(String adress){
		this.adress=adress;
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
}