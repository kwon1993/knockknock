package com.knockknock.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.member.MemberDTO;

@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO);
	public MemberDTO findById(String id);
	public MemberDTO findByEmail(MemberDTO memberDTO);
	public MemberDTO findByName(MemberDTO memberDTO);

	public MeetingDTO getMML(String email);

	public MemberDTO checkEmail(MemberDTO memberDTO);

}
