package com.example.SQLInjectionDemo.model;

public class User {
	private String userName;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String name, String pass) {
		userName = name;
		password = pass;
		
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
