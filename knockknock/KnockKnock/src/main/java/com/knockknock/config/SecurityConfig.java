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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

import com.knockknock.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public PasswordEncoder passwordEncoder;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	//요거 추가해주니 로긴 로그아웃창 수정완료
	@Bean
	public SpringSecurityDialect springSecurityDialect(){
		return new SpringSecurityDialect();
	}

	@Override
	public void configure(WebSecurity web) throws Exception { // 허용되어야할 경로들
		//이거 있으면, 모든 인증처리를 무시해서, antMatcher(인증필요한곳)을 해도 인증처리가 안됨
		//web.ignoring().antMatchers("/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//기존설정----------------------------------------------------------
//		http.csrf().disable().
//		authorizeRequests()
//			.antMatchers("/**","/reviewList").permitAll()
//			.antMatchers("/admin").hasRole("A")
//			.anyRequest().authenticated()
//			.and()
//		.formLogin()
//			.loginPage("/login")
//			.defaultSuccessUrl("/")
//			.failureUrl("/login")
//			.and()
//		.logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/")
//			.permitAll();
//		//loginProcessingUrl없애니 됨
//		
//		http
//	    	.csrf()
//	    	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
//		
//		//스마트에디터 관련 설정
//	    http
//		    .headers()
//		    .frameOptions()
//		    .disable();	
	    
	    //실제필요설정------------------------------------------------------------
//	    http.csrf().disable().
		http
		.authorizeRequests()
			
			.antMatchers("/**","/reviewList").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login")
			.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.permitAll();
		//loginProcessingUrl없애니 됨
		
		http
	    	.csrf()
	    	.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		
		//스마트에디터 관련 설정
	    http
		    .headers()
		    .frameOptions()
		    .disable();	
	}

	//로그인 처리 시, 인증에 대한 처리.
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobal작동");
		auth.eraseCredentials(false).userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

			
}
