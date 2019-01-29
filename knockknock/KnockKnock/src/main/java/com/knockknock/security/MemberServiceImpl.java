package com.knockknock.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//회원아이디(이메일)에 맞는 등급 등을 꺼내기 위해 사용?
	//private Map<String,MemberDTO> accounts = new HashMap<>();
	
	@Override
	public void register(MemberDTO memberDTO) {
		//이메일 주소를 MAP으로 넣는다.
		//accounts.put(memberDTO.getEmail(), memberDTO);
		
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		memberMapper.register(memberDTO);
	
	}

	/*
	 * public MemberDTO findByEmail(String username) { //이메일주소로 찾는다 return
	 * accounts.get(username); }
	 */

	
	
}
