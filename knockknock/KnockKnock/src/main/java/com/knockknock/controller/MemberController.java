package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping("/create")
	public String create(MemberDTO memberDTO) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDTO.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
		ms.save(memberDTO);
		return "redirect:/";
	}

}
