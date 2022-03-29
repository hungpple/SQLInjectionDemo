package com.example.SQLInjectionDemo.model;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//@Entity
public class Student {
	private int id;
	private String name;
	private String email;
	private String address;
	private String enrolledclass;
	
	public Student() {
		super();
	}
	
	public Student(String name, String email, String address, String enrolledclass) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.enrolledclass = enrolledclass; 
	}
	
	public Student(int id, String name, String email, String address, String enrolledclass) {
		this(name, email, address, enrolledclass);
		this.id = id;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnrolledclass() {
		return enrolledclass;
	}

	public void setEnrolledclass(String enrolledclass) {
		this.enrolledclass = enrolledclass;
	}
	

}
