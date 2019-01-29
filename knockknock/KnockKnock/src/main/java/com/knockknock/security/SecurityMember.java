package com.knockknock.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.knockknock.dto.member.MemberDTO;

public class SecurityMember extends User{
	
	public SecurityMember(MemberDTO memberDTO) {
		super(memberDTO.getEmail(),memberDTO.getPassword(),makeAuth(memberDTO));
	}
		
	private static List<GrantedAuthority> makeAuth(MemberDTO memberDTO) {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(memberDTO.getGrade()));
		
		return list;
	}
}
