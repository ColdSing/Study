package com.fxx.vo;

public class EmpVO {
	private Integer id;
	private String name;
	private Double sum;
	private String adress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSum() {
		return sum;
	}
	public void setSum(Double sum) {
		this.sum = sum;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public EmpVO(Integer id, String name, Double sum, String adress) {
		this.id = id;
		this.name = name;
		this.sum = sum;
		this.adress = adress;
	}
	
	public EmpVO() {
	}
	
}
