package com.SpringSercurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
 
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	//auth.userDetailsService(userDetailsService)
	//.passwordEncoder(bCryptPasswordEncoder);
		auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder.encode("abcd")).roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder.encode("abcd")).roles("USER", "ADMIN");
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.formLogin().loginPage("/login");
 	     http.csrf().disable();
 	     http.authorizeRequests().antMatchers("/user/*", "/").hasRole("USER");
 	     http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
 	   //  http.authorizeRequests().antMatchers("/login", "/signup").permitAll().anyRequest().authenticated();
 	     http.exceptionHandling().accessDeniedPage("/404");
}
	
	
}