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

import com.real.authen.model.User;
import com.real.authen.service.UserService;
import com.real.response.ResponseModel;

@RestController
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@RequestMapping("/initAdmin")
	public String InitialAdmin() {
		User user = new User("Sarindy", "Ouk", "admin@dnynn.com", "123456", 1);
		userService.addUser(user, "ADMIN");
		return "Admin Created";
	}

	@RequestMapping("/initApi")
	public String InitialApi() {
		User user = new User("Sarindy", "Ouk", "api@dnynn.com", "123456", 1);
		userService.addUser(user, "API");
		return "Api Created";
	}

	@RequestMapping(value = "/api/auth/addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseModel> addUser(@RequestBody UserWrapObject userWrap) {
		
		/*
		 * This is a postman script
		 * {
			"role":"API",
			"user":{
				"firstName":"sarindy",
				"lastName":"Ouk",
				"email":"developer@dnynn.com",
				"password":"123456"
			}
		}*/
		

		try {

			User user = new User();
			

			user = userWrap.getUser();

			userService.addUser(user, userWrap.getRole());
			logger.info(user.toString() + " User added");

			return new ResponseEntity<ResponseModel>(new ResponseModel("000", "User added", user), HttpStatus.OK);

		} catch (Exception err) {
			StackTraceElement[] elements = err.getStackTrace();
			String error = null;
			error = "Class Name:" + elements[0].getClassName() + " Method Name:" + elements[0].getMethodName()
					+ " Line Number:" + elements[0].getLineNumber() + "Error Message : " + err.getMessage();
			logger.error(error);
			return new ResponseEntity<ResponseModel>(new ResponseModel("999", "System Error", userWrap),
					HttpStatus.BAD_REQUEST);
		}

	}

}
