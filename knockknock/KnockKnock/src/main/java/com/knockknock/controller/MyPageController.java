package com.knockknock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.member.MemberDTO;
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
		model.addAttribute("profile", memberService.getProfile(username));
		model.addAttribute("getPet",memberService.getPet(username));
		return "member/MyProfile";
	}
	
	@RequestMapping("/updateProfileComplete")
	@ResponseBody
	public List<MemberDTO> profileUpdate(Model model, @RequestBody ProfileVDTO profileVDTO, Authentication authentication) {
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String username = user.getUsername();
		//업데이트매퍼 실행->업데이트
		//셀렉트매퍼 실행->셀렉트
		System.out.println(profileVDTO.getMemberNumber());
		memberService.profileUpdate(profileVDTO);
		
		return memberService.getProfile(username);
		
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

	
	/*ash
	 * @RequestMapping("/MyVisitList") public String myVisitList(Model
	 * model, @RequestParam("memberNumber") int memberNumber) {
	 * System.out.println(memberNumber);
	 * model.addAttribute("myVisitLists",memberService.myVisitList(memberNumber));
	 * 
	 * return "member/MyVisitList"; }
	 */

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
