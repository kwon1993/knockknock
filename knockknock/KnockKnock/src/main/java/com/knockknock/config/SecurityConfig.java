package com.knockknock.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.knockknock.security.UserDetailService;

 @Configuration
  
 @EnableWebSecurity public class SecurityConfig extends
 WebSecurityConfigurerAdapter{
	 
	 @Autowired
	 public PasswordEncoder passwordEncoder;
	 
	 @Autowired
	 private UserDetailService userDetailService;
	 
  
 @Override public void configure(WebSecurity web) throws Exception { // 허용되어야할 경로들 
	 web.ignoring().antMatchers("/**"); // #3
 }
  
  //인증이 필요한 놈들부터 먼저 authenticated처리 하고, 마지막에 permitAll로 나머지 freeauthenticated처리 
  //먼저 permitAll부터 하면, 첫번째꺼만 적용되어 이후의 authenticated처리는 무효화 됨
  
  @Override protected void configure(HttpSecurity http) throws Exception {
  http.authorizeRequests() 
  .antMatchers().permitAll()
  .antMatchers("/방찾기").authenticated()
  .and()
  .formLogin()
  .loginPage("/registerStart")
  .defaultSuccessUrl("/");
  } 
 
	 
	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder(); }
	 */
  
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
	  auth.eraseCredentials(false).userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
  }
}
 