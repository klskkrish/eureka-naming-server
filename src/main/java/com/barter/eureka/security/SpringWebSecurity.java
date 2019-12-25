package com.barter.eureka.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sureshk
 *
 */
@EnableWebSecurity
public class SpringWebSecurity extends WebSecurityConfigurerAdapter {

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.HttpSecurity)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//eureka client register csrf false
		http.httpBasic().and().authorizeRequests().antMatchers("/eureka/apps", "/eureka/apps/**").permitAll().anyRequest()
				.authenticated().and().csrf().disable();
		//authenticate all calls
		// http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
}
