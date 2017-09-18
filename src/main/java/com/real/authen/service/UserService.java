package com.real.authen.service;

import java.util.List;

import com.real.authen.model.User;

public interface UserService {
	
	public User addUser(User user,String role);
	
	public User updateUser(User user, User updatedUser,String newRole);
	
	public User findUserByEmail(String email);
	
	public User findUserByUid(int id);
	
	public List<User> findUserFirstNameContain(String firstName);
	
	public List<User> findUserLastNameContain(String lastName);
	
	public List<User> getAllUsers();
	
	
	

}
