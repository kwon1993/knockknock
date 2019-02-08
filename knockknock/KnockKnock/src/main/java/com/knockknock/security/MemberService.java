package com.knockknock.security;

import java.util.List;

import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	
	// 내 모임 리스트 - 신청
	public List<MeetingVDTO> getMMLJ(String email);
	
	// 내 모임 리스트 - 주최
	public List<MeetingVDTO> getMMLM(String email);
}
