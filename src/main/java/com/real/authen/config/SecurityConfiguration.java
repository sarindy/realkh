package com.real.authen.config;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		//http.authorizeRequests().antMatchers("/api/**").hasAnyAuthority("API").antMatchers("/admin/**")
				//.hasAnyAuthority("ADMIN").antMatchers("/user/**").hasAnyAuthority("USER").anyRequest().permitAll().and()
				//.httpBasic().and().csrf().disable();
		// .fullyAuthenticated().and().httpBasic().and().csrf().disable();
		
		http.authorizeRequests().antMatchers("/api/**").hasAnyAuthority("API").antMatchers("/admin/**")
		.hasAnyAuthority("ADMIN").antMatchers("/user/**").hasAnyAuthority("USER").anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
		
 

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}

@Configuration
class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session created");
		event.getSession().setMaxInactiveInterval(10);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		event.getSession().setMaxInactiveInterval(10);
		System.out.println("session destroyed");
	}
}
