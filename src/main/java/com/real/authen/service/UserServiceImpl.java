package com.real.authen.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.authen.model.Role;
import com.real.authen.model.User;
import com.real.authen.repo.RoleRepo;
import com.real.authen.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RoleRepo roleRepo;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("null")
	@Override
	public User addUser(User user, String role) {

		try {
			User userModel = new User();
			userModel = userRepo.findByEmail(user.getEmail());

			if (userModel == null) {
				Role roleModel = new Role();
				roleModel = roleRepo.findByRole(role);
				if (roleModel != null) {
					user.setRoles(new ArrayList<Role>(Arrays.asList(roleModel)));
					userRepo.save(user);
					logger.info(user.toString() + " User added");
					return user;	
				}
				logger.info(roleModel.toString() + " Role not exist");
				return null;

			}
			logger.info(user.toString() + " User already existed");
			return null;
		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}

	}

	@Override
	public User updateUser(User user, User updatedUser, String newRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserByUid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserFirstNameContain(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserLastNameContain(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
