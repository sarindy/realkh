package com.real.authen.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.real.authen.model.Role;
import com.real.authen.repo.RoleRepo;

public class RolerServiceImpl implements RoleService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role addRole(Role role) {

		// TODO rem the debug
		try {
			if (role != null) {
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
	public Role updateRole(Role role) {
		try {
			if (role != null) {
				roleRepo.save(role);
				logger.info(role.toString() + " Added");
				System.out.println(role.toString() + " Added");
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
	public Role findRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findRoleByUid(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return null;
	}

}
