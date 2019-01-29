package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.security.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping("/registerStart")
	public String registerStart() {
		return "member/register";
	}
	
	@RequestMapping("/register")
	public String member(Model model,MemberDTO memberDTO) {
		System.out.println(memberDTO);
		memberService.register(memberDTO);
		return "member/registerComplete";
	}
	
	@RequestMapping("/login")
	public String loginTest() {
		return "member/register";
	}
}
