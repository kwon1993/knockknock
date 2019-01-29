package com.knockknock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 허용되어야 할 경로들
        web.ignoring().antMatchers("/**"); // #3
    	
    }
    
    //인증이 필요한 놈들부터 먼저 authenticated처리 하고, 마지막에 permitAll로 나머지 free authenticated처리
    //먼저 permitAll부터 하면, 첫번째꺼만 적용되어 이후의 authenticated처리는 무효화 됨
    @Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
			.antMatchers("/simpleRoomSearch").authenticated()
			.antMatchers("/**").permitAll();
	}
}
