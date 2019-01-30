package com.knockknock.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.knockknock.dto.member.MemberDTO;


@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO);
	public MemberDTO findById(String id);
}
