package com.knockknock.security;

import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.member.MemberDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	
	// 내 모임 리스트
	public MeetingDTO getMML(String email);
}
