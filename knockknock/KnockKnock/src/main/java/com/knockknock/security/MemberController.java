package com.knockknock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.MemberDTO;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/register")
	public String registerStart() {
		return "member/register";
	}

	//1.회원등록
	@RequestMapping("/create")
	public String member(Model model, MemberDTO memberDTO) {
		//2.memberService의 register호출
		memberService.register(memberDTO);
		
		return "member/registerComplete";
	}
	
	//기본적으로 '로그인'누르면 연결. 그외에 인증처리 안된상태에서 방찾기 등 누르면 로그인으로
	@RequestMapping("/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("/loginComplete")
	public String loginComplete(MemberDTO memberDTO) {
		
		return "etc/fragments/main_layout";
	}
}
