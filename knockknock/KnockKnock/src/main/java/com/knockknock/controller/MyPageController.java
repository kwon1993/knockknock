package com.knockknock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.ProfileVDTO;

@Controller
public class MyPageController {
	
	@RequestMapping("/profileMain")
	public String profileMain(ProfileVDTO profileVDTO) {
		return "";
	}
	

}
