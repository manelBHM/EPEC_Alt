package com.RestApi.sercurity;

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
	auth.userDetailsService(userDetailsService)
	.passwordEncoder(bCryptPasswordEncoder);
	
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	// http.formLogin();
	 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	 http.authorizeRequests().antMatchers("/signup/**","/login/**")
	 .permitAll();
	 http.authorizeRequests().antMatchers(HttpMethod.POST, "/persones/**").hasAuthority("ADMIN").anyRequest().authenticated();
	 http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**/**").hasAnyAuthority("ADMIN", "USER").anyRequest().authenticated();
	 http.authorizeRequests().antMatchers(HttpMethod.PUT, "/**/**").hasAnyAuthority("ADMIN").anyRequest().authenticated();
	 http.authorizeRequests().anyRequest().authenticated();
	 http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
	 http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
	
	
}