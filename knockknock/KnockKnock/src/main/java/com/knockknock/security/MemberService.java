package com.knockknock.security;

import java.util.List;

import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.JoinMeetingDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;
import com.knockknock.dto.member.VisitDTO;

public interface MemberService{

	public void register(MemberDTO memberDTO);
	
	// 내 모임 리스트 - 신청
	public List<MeetingVDTO> getMMLJ(String email);
	
	// 내 모임 리스트 - 주최
	public List<MeetingVDTO> getMMLM(String email);

	//비밀번호변경(임시비밀번호)
	public void changePassword(MemberDTO memberDTO);
	
	//비밀번호변경(수정비밀번호)
	public void changeRealPassword(MemberDTO memberDTO);
	
	//마이페이지-프로필가져오기
	public List<MemberDTO> getProfile(String username);
	
	//마이페이지-프로필수정
	public void profileUpdate(ProfileVDTO profileVDTO);
	
	//마이페이지-프로필수정(강아지없을때)
	public void profileUpdate2(ProfileVDTO profileVDTO);
	
	//마이페이지-프로필사진업데이트
	public void saveImageDir(String finalImage,String username); 
	
	//마이페이지-프로필사진경로겟
	public MemberDTO getImageDir(String username);
	
	//겟펫
	public List<MemberDTO> getPet(String username);

	// 내 이벤트 리스트
	public List<EventVDTO> getMEL(String email);

//	public List<VisitVDTO> myVisitList(int memberNumber);
	
	// 내 방문 신청 리스트
	public List<VisitDTO> getMVL(String email);
	
	// 모임 신청 취소
	public int deleteJM(int writingNumber, String email);

	// 모임 개설 취소
	public int deleteMM(int writingNumber, String email);
	
	// 이벤트 참가 취소
	public int deleteJE(int writingNumber, String email);

	// 방문 신청 취소
	public int deleteV(int writingNumber, String email);

}
