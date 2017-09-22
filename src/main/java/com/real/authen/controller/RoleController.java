package com.real.authen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.real.authen.model.Role;
import com.real.authen.service.RoleService;
import com.real.response.ResponseModel;

@RestController
public class RoleController  {
	
	@Autowired
	private RoleService roleService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/initRole")
	public String InitialRole() {
		Role role = new Role();
		role.setRole("ADMIN");
		roleService.addRole(role);
		role = new Role();
		role.setRole("API");
		roleService.addRole(role);
		role = new Role();
		role.setRole("USER");
		roleService.addRole(role);
		return "Default Roles Created";
	}

	@RequestMapping(value="/api/auth/addRole",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseModel> addRole(@RequestBody Role role) {
		
		try {
			
			if (roleService.addRole(role) != null){
				logger.info(role.toString() + " Added");
				return new ResponseEntity<ResponseModel>(new ResponseModel("000","Role Created",role) ,HttpStatus.OK);	
			}
			return new ResponseEntity<ResponseModel>(new ResponseModel("001","Role not create. Maybe already existed or null",role) ,HttpStatus.OK);
			
			
		}catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return new ResponseEntity<ResponseModel>(new ResponseModel("999","System Error",role) ,HttpStatus.BAD_REQUEST);
		}
			
	}

}
