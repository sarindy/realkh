package com.real.authen.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.real.authen.model.Role;
import com.real.authen.repo.RoleRepo;

@Service
public class RolerServiceImpl implements RoleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role addRole(Role role) {

		// TODO rem the debug
		try {
			if (role != null) {
				if (roleRepo.findByRole(role.getRole()) != null) {
					logger.info(role.toString() + " already existed");
					System.out.println(role.toString() + " Role Existed");
					return null;
				}
				role.setRole(role.getRole().toUpperCase());
				roleRepo.save(role);
				logger.info(role.toString() + " Added");
				System.out.println(role.toString() + " Added");
				return role;
			}

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
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role updateRole(Role role, Role newRole) {

		try {
			if (role != null) {

				Role updatedRole = new Role();

				updatedRole = roleRepo.findOne(role.getId());
				if (updatedRole == null) {
					logger.info(role.toString() + " role not existed");
					System.out.println(role.toString() + " Role not Existed");
					return null;
				}
				updatedRole.setRole(newRole.getRole());

				roleRepo.save(updatedRole);
				logger.info(updatedRole.toString() + " updated");
				System.out.println(updatedRole.toString() + " Updated");
				return role;
			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}
		return null;

	}

	@Override
	public Role findRole(String role) {
		try {

			Role role1 = new Role();

			role1 = roleRepo.findByRole(role);
			if (role1 != null) {
				logger.info(role.toString() + " Searched");
				System.out.println(role.toString() + " Searched");
				return role1;
			} else {
				logger.info("Role not found.");
				System.out.println("Role not found.");
				return null;
			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}

	}

	
	@SuppressWarnings("unused")
	@Override
	public List<Role> findRoleContain(String role) {

		try {

			List<Role> roles = new ArrayList<Role>();
			roleRepo.findByRoleContaining(role).forEach(roles::add);

			if (roles != null) {
				logger.info(role + " Searched");
				System.out.println(role + " Searched");
				return roles;
			} 

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}
		
		System.out.println("Role not found");
		logger.info("Role not found");
		return null;

	}

	@Override
	public Role findRoleById(int id) {
		try {

			Role role = new Role();

			role = roleRepo.findOne(id);
			if (role != null) {
				logger.info(role.toString() + " Searched");
				System.out.println(role.toString() + " Searched");
				return role;
			} else {
				logger.info("Role not found.");
				System.out.println("Role not found.");
				return role;
			}

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return null;
		}

	}

}
