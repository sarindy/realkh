package com.real.authen.service;

import java.util.List;

import com.real.authen.model.User;

public interface UserService {
	
	public User addUser(User user);
	
	public User updateUser(User user);
	
	public User findUser(User user);
	
	public User findUserByUid(User user);
	
	public List<User> getAllUsers();
	
	

}
