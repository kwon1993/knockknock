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

import com.knockknock.dto.event.MeetingDTO;
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
		//3.memberDTO의 패스워드를 인코딩처리한다
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		//4.인코딩 후, memberMapper로 등록을 간다
		memberMapper.register(memberDTO);
	}

	@Override
	public MeetingDTO getMML(String email) {
		return memberMapper.getMML(email);
	}
}
