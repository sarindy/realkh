package com.real.authen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.real.authen.model.User;

@Configuration
public class UserAuthentication {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public Boolean Authenticated(User user, String password) {
		return bCryptPasswordEncoder.matches(password, user.getPassword());
	}

}
