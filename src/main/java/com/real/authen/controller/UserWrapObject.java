package com.real.authen.controller;

import com.real.authen.model.User;

public class UserWrapObject {
	private User user;
	private String role;
	public UserWrapObject() {
		
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}
