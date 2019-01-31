package com.knockknock.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.knockknock.dto.member.MemberDTO;

public class SecurityMember extends User{

	private static final long serialVersionUID = 1L;

	public SecurityMember(MemberDTO memberDTO) {
		super(memberDTO.getEmail(),memberDTO.getPassword(),makeAuth(memberDTO));
	}
		
	private static Collection<GrantedAuthority> makeAuth(MemberDTO memberDTO) {
		Collection<GrantedAuthority> list = new ArrayList<>();
		System.out.println("makeAuth 작동");
		list.add(new SimpleGrantedAuthority(memberDTO.getGrade()));
		
		return list;
	}
}
