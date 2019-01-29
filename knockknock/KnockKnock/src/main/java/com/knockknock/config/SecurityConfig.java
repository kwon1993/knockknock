package com.knockknock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//이 어노테이션으로 스프링 시큐리티의 웹 보안과 스프링 MVC 통합 가능
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
	@Override
	// configure(HttpSecurity)는 URL 경로의 접근 가능 여부를 정의
	protected void configure(HttpSecurity http) throws Exception {
		// 새로운 계정 생성도 permitAll에 넣어서 권한 없이 접근 가능하도록 설정해준다
		http.authorizeRequests()
		.antMatchers("/", "etc/SharingGuide", "/create")
		.permitAll()
		// admin 이하의 모든 페이지
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and().
			logout().
			permitAll();
	}

	// 좀 더 현실성 있게 구현하기 위해 삭제
	/*
	 * @Bean
	 * 
	 * @Override public UserDetailsService userDetailsService() { UserDetails user =
	 * User.withDefaultPasswordEncoder().username("user").password("password").roles
	 * ("USER") .build();
	 * 
	 * return new InMemoryUserDetailsManager(user); }
	 */
	
	// 패스워드 인코딩 설정
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
    
    
}
