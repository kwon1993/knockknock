package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.PageMaker;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.service.BranchService;

@Controller
public class MainController {

	@Autowired
	BranchService branchService;
	
	//메인화면 스타트
	@RequestMapping("/")
	public String start(Model model, MemberDTO memberDTO) {
		return "home/Home";
	}
	
	//메인화면 심플방검색
	@GetMapping("/simpleRoomSearch")
	public String simpleRoomSearch(Model model, BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("lists", branchService.simpleRoomSearchList(branchDetailVDTO));
		return "branch/FindingRoom";
	}
	
	//네비게이션바 '방찾기'
	@RequestMapping("/findingRoom")
	public String toFindingRoom(Model model, BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("lists", branchService.findingRoomList(branchDetailVDTO));
		System.out.println(branchDetailVDTO.getTheme());
		return "branch/FindingRoom";
	}
	
	//네비게이션바 '카테고리로 방찾기'
	@RequestMapping(value ="/findingCategoryRoom", method=RequestMethod.GET)
	public String toFindingCategoryRoom(Model model, Criteria cri) throws Exception {
		model.addAttribute("lists", branchService.findingCategoryRoomList(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(branchService.categoryCountService(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "branch/FindingCategoryRoom";
	}
	
	//네비게이션바 '모임 및 이벤트
	@RequestMapping("/meetingAndEventMain")
	public String toMeetingAndEvent() {
		return "event/MeetingAndEventMain";
	}
	
	//네비게이션바 '언어변환'
	@RequestMapping("/toTranslateLanguage")
	public String toTranslateLanguage() {
		return "";
	}
	
	//네비게이션바 '입주안내'
	@RequestMapping("/toSharingGuide")
	public String toSharingGuide() {
		return "etc/SharingGuide";
	}
	
	//네비게이션바 '고객센터'
	@RequestMapping("/toFAQ")
	public String toFAQ() {
		return "etc/FAQ";
	}

}
