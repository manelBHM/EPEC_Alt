package lucky.airport.application.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	
	 @Override
	 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 
			auth.inMemoryAuthentication()
		 	.withUser("admin").password("1234").roles("USER","ADMIN");
	
	 	auth.inMemoryAuthentication()
	 	.withUser("user").password("1234").roles("USER");
	 
	 }
	   @Override
	 	protected void configure(HttpSecurity http) throws Exception {
	 	     http.formLogin().loginPage("/adminlogin");
	 	     http.csrf().disable();
	 	     http.authorizeRequests().antMatchers("/user/*").hasRole("USER");
	 	     http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");
	 	     http.exceptionHandling().accessDeniedPage("/404");
	 }
}