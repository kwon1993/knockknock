package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.ProfileVDTO;
import com.knockknock.security.MemberService;

@Controller
public class MyPageController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/profileMain")
	public String profileMain(Model model, ProfileVDTO profileVDTO, Authentication authentication) {
		// 현재 로그인 사용자 정보에 접근
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		String username = user.getUsername();
		System.out.println("유저아이디:" + user.getUsername());

		System.out.println(memberService.getProfile(username));
		model.addAttribute("profile", memberService.getProfile(username));
		return "member/MyProfile";
	}

	@RequestMapping("/MyEventList")
	public String myEventList(Model model, ProfileVDTO profileVDTO) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());

		model.addAttribute("MEL", memberService.getMEL(user.getUsername()));

		return "member/MyEventList";
	}

	@RequestMapping("/MyMeetingList")
	public String myMeetingList(Model model, ProfileVDTO profileVDTO) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		System.out.println(user.getUsername());

		model.addAttribute("MMLJ", memberService.getMMLJ(user.getUsername()));
		model.addAttribute("MMLM", memberService.getMMLM(user.getUsername()));

		return "member/MyMeetingList";
	}

	@RequestMapping("/MyVisitList")
	public String myVisitList(Model model, ProfileVDTO profileVDTO) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());

		model.addAttribute("MVL", memberService.getMVL(user.getUsername()));
		return "member/MyVisitList";
	}

}
