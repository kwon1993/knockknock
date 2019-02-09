package com.knockknock.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.JoinMeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;
import com.knockknock.dto.member.VisitDTO;

@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO);
	public MemberDTO findById(String id);
	public MemberDTO findByEmail(MemberDTO memberDTO);
	public MemberDTO findByName(MemberDTO memberDTO);

	public List<MeetingVDTO> getMMLJ(String email);
	public List<MeetingVDTO> getMMLM(String email);

	public MemberDTO checkEmail(MemberDTO memberDTO);

	public void changePassword(MemberDTO memberDTO);
	//마이페이지
	public List<MemberDTO> getProfile(String username);
	//마이페이지
	public List<MemberDTO> getPet(String username);
	//마이페이지-프로필수정
	public void profileUpdate(ProfileVDTO profileVDTO);
	
	public List<EventVDTO> getMEL(String email);
	
	public List<VisitDTO> getMVL(String email);
	
	public int deleteJM(int writingNumber, String email);
	
	public int deleteMM(int writingNumber, String email);
	
	public int deleteJE(int writingNumber, String email);
}
