package com.knockknock.security;

import java.util.List;

import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;

public interface MemberService{
	public void register(MemberDTO memberDTO);
	
	// 내 모임 리스트 - 신청
	public List<MeetingVDTO> getMMLJ(String email);
	
	// 내 모임 리스트 - 주최
	public List<MeetingVDTO> getMMLM(String email);

	//비밀번호변경(임시비밀번호)
	public void changePassword(MemberDTO memberDTO);
	
	//마이페이지
	public ProfileVDTO getProfile(String username);

}
