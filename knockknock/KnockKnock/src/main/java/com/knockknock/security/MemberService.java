package com.knockknock.security;

import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	//비밀번호변경(임시비밀번호)
	public void changePassword(MemberDTO memberDTO);
	//마이페이지
	public ProfileVDTO getProfile(String username);
	// 내 모임 리스트
	public MeetingDTO getMML(String email);
}
