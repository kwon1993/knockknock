package com.knockknock.mapper;

import org.apache.ibatis.annotations.Mapper;

<<<<<<< HEAD
import com.knockknock.dto.member.MemberDTO;
=======
@Mapper
public interface MemberMapper {
>>>>>>> 4ae9cf6c54ad329b25714d5c841a4acd4ca2688b

@Mapper
public interface MemberMapper {
	public void register(MemberDTO memberDTO);
	public MemberDTO findById(String id);
}
