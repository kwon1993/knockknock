package com.knockknock.security;

import com.knockknock.dto.member.MemberDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	public void changePassword(MemberDTO memberDTO);
}
