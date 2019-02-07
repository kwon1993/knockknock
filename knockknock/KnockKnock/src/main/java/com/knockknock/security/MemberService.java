package com.knockknock.security;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	public void changePassword(MemberDTO memberDTO);
	//마이페이지
	public ProfileVDTO getProfile(String username);
}
