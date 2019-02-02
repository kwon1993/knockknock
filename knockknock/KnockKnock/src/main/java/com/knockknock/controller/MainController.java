package com.knockknock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.BranchTestDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.service.TestService;

@Controller
public class MainController {

	@Autowired
	TestService testService;

	@RequestMapping("/")
	public String start(Model model, MemberDTO memberDTO) {
		return "home/home";
	}

	@RequestMapping("/simpleRoomSearch")
	public String simpleRoomSearch(Model model, BranchTestDTO branchTestDTO) {
		model.addAttribute("lists", testService.list(branchTestDTO));
		return "branch/FindingRoom";
	}

	// AJAX 방리스트받기 테스트
	@PostMapping("/branch/FindingRoom")
	@ResponseBody
	public List<BranchTestDTO>roomSearch(Model model, @ModelAttribute BranchTestDTO branchTestDTO) {
		System.out.println(branchTestDTO.getAddress());
		model.addAttribute("list",testService.list(branchTestDTO));
		return testService.list(branchTestDTO);
	}

	@RequestMapping("b")
	public String toFindingRoom() {

		return "branch/FindingCategoryRoom";
	}

	@RequestMapping("c")
	public String toFindingCategoryRoom() {
		return "branch/FindingCategoryRoom";
	}

	@RequestMapping("/meetingAndEventMain")
	public String toMeetingAndEvent() {
		return "event/MeetingAndEventMain";
	}

	@RequestMapping("e")
	public String toTranslateLanguage() {
		return "";
	}
	
	@RequestMapping("f")
	public String toSharingGuide() {
		return "etc/SharingGuide";
	}

}
