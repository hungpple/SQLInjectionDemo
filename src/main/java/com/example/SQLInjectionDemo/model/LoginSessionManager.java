package com.example.SQLInjectionDemo.model;

import javax.servlet.http.HttpSession;

public class LoginSessionManager {
	private static final String SESSION_KEY_USER = "username";
	
	public User getUser(HttpSession session) {
		User user = (User)session.getAttribute(SESSION_KEY_USER);
		if(user == null) {
			user = new User();
			this.setUser(session, user);
		}
		return user;
	}
	
	public void setUser(HttpSession session, User user) {
		session.setAttribute(SESSION_KEY_USER, user);
	}
	
	public void removeUser (HttpSession session) {
		session.removeAttribute(SESSION_KEY_USER);
	}
}
