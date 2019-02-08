package com.knockknock.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;

@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO);
	public MemberDTO findById(String id);
	public MemberDTO findByEmail(MemberDTO memberDTO);
	public MemberDTO findByName(MemberDTO memberDTO);

	public List<MeetingVDTO> getMMLJ(String email);
	public List<MeetingVDTO> getMMLM(String email);

	public MemberDTO checkEmail(MemberDTO memberDTO);

}
