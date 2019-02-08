package com.knockknock.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.ProfileVDTO;
import com.knockknock.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//회원아이디(이메일)에 맞는 등급 등을 꺼내기 위해 사용?
	//private Map<String,MemberDTO> accounts = new HashMap<>();
	
	@Override
	public void register(MemberDTO memberDTO) {
		//3.memberDTO의 패스워드를 인코딩처리한다
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		//4.인코딩 후, memberMapper로 등록을 간다
		memberMapper.register(memberDTO);
	}

	@Override
	public List<MeetingVDTO> getMMLJ(String email) {
		return memberMapper.getMMLJ(email);
	}

	@Override
	public List<MeetingVDTO> getMMLM(String email) {
		return memberMapper.getMMLM(email);
	}

	public void changePassword(MemberDTO memberDTO) {
		System.out.println("랜덤번호:");
//		int randomInt;
//		String randomStr="";
//		String tempPassword="";
//		Random rnd = new Random();
//
//		randomInt = (int)(Math.random()*9)+1;
//		randomStr = String.valueOf((char) ((int) (rnd.nextInt(26)) + 97));
//		
//		
//		for(int i=0; i<9; i++) {
//			tempPassword+=randomInt+randomStr;
//		}
		
//		System.out.println("임시비번은:"+tempPassword);
		
//		memberDTO.setPassword(passwordEncoder.encode("1233"));
		
//		memberMapper.changePassword(memberDTO);
	}
	
	public ProfileVDTO getProfile(String username){
		return memberMapper.getProfile(username);
	}		


}
