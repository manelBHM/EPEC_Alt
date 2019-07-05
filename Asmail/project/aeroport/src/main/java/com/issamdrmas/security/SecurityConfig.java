package com.issamdrmas.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) 
	      throws Exception {
	        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	        auth.inMemoryAuthentication()
	     	.withUser("admin").password(encoder.encode("1234")).roles("USER","ADMIN");
		 	 auth.inMemoryAuthentication()
		 	.withUser("pilote").password(encoder.encode("1234")).roles("USER");
	    }
	 
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	         http.formLogin().loginPage("/login");
	 	     http.csrf().disable();
	 	     http.authorizeRequests().antMatchers("/pilote/*").hasRole("USER");
	 	     http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
	 	     http.exceptionHandling().accessDeniedPage("/404");
	    }
}
