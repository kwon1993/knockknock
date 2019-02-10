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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.event.JoinMeetingDTO;
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
		if(profileVDTO.getAnimal().length()>0) {
			System.out.println("Animal이 있다");
			memberService.profileUpdate(profileVDTO);
		}else {
			System.out.println("Animal이 없다");
			memberService.profileUpdate2(profileVDTO);
		}
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

	// 신청한 모임 취소
	@RequestMapping("/deleteJM")
	public String deleteJM(Model model, @RequestParam("writingNumber") int writingNumber) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		memberService.deleteJM(writingNumber, user.getUsername());
		
		// 신청, 개설한 모임 리스트 다시 받아오기
		model.addAttribute("MMLJ", memberService.getMMLJ(user.getUsername()));
		model.addAttribute("MMLM", memberService.getMMLM(user.getUsername()));
		
		
		return "member/MyMeetingList";
	}
	
	// 개설한 모임 취소
	@RequestMapping("/deleteMM")
	public String deleteMM(Model model, @RequestParam("writingNumber") int writingNumber) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		memberService.deleteMM(writingNumber, user.getUsername());
		
		// 신청, 개설한 모임 리스트 다시 받아오기
		model.addAttribute("MMLJ", memberService.getMMLJ(user.getUsername()));
		model.addAttribute("MMLM", memberService.getMMLM(user.getUsername()));
		
		
		return "member/MyMeetingList";
	}
	
	// 참가한 이벤트 취소
	@RequestMapping("/deleteJE")
	public String deleteJE(Model model, @RequestParam("writingNumber") int writingNumber) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		memberService.deleteJE(writingNumber, user.getUsername());
		
		// 참가한 모임 리스트 다시 받아오기
		model.addAttribute("MEL", memberService.getMEL(user.getUsername()));
		
		
		return "member/MyEventList";
	}
	
	// 방문 신청 취소
	@RequestMapping("/deleteV")
	public String deleteV(Model model, @RequestParam("writingNumber") int writingNumber) {

		// 현재 로그인 사용자 정보에 접근
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();

		model.addAttribute("user", user.getUsername());
		memberService.deleteV(writingNumber, user.getUsername());
		
		// 방문 신청 리스트 다시 받아오기
		model.addAttribute("MVL", memberService.getMVL(user.getUsername()));
		
		return "member/MyVisitList";
	}

}
