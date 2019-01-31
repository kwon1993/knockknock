package com.knockknock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.mapper.MemberMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("loadUserByUsername 작동");
		MemberDTO memberDTO = memberMapper.findById(username);
		
		
		if(memberDTO!=null) {
			return new SecurityMember(memberDTO);
		}
		else {
			return null;
		}
	}
}
