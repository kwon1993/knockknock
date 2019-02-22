package com.knockknock.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.UserConnectionDTO;
import com.knockknock.mapper.UserMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	@Autowired
    private final UserMapper userMapper;

    public void signUp(UserConnectionDTO userConnectionDTO) {
    	System.out.println("UserService의 signUp메서드입니다");
//        final MemberDTO memberDTO = userMapper.signUp(userConnectionDTO);
         userMapper.signUp(userConnectionDTO);
    }

    public MemberDTO findBySocial(UserConnectionDTO userConnectionDTO) {
    	System.out.println("UserService의 findBySocial메서드입니다");
        final MemberDTO memberDTO = userMapper.findBySocial(userConnectionDTO);
        if (memberDTO == null) throw new RuntimeException();
        return memberDTO;
    }

    public boolean isExistUser(UserConnectionDTO userConnectionDTO) {
    	System.out.println("UserService의 isExistUser메서드입니다");
        final MemberDTO memberDTO = userMapper.findBySocial(userConnectionDTO);
        System.out.println("findBySocial의 리턴값:"+memberDTO);
        return (memberDTO != null);
    }
}
