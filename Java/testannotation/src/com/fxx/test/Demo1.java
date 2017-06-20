package com.fxx.test;

@FxxTable(value = "tb_student")
	public class Demo1 {
	@FxxField(cloumName = "id", length = 10, type = "int")
	private int id;
	@FxxField(cloumName = "sname", length = 10, type = "varchar")
	private String studentName;
	@FxxField(cloumName = "age", length = 3, type = "int")
	private int age;
	
	public Demo1() {
	}
	public Demo1(int id, String studentName, int age) {
		this.id = id;
		this.studentName = studentName;
		this.age = age;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	public static void main(String[] args) {
		
	}

}
