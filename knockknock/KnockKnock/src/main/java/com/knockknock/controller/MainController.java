package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.branch.BranchTestDTO;
import com.knockknock.service.TestService;

@Controller
public class MainController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/")
	public String start() {
		return "etc/fragments/main_layout";
	}
	
	@RequestMapping("/simpleRoomSearch")
	public String simpleRoomSearch(Model model, BranchTestDTO branchTestDTO) {
		model.addAttribute("list",testService.list(branchTestDTO));
//		model.addAttribute("address",address);
		
		return "branch/FindingRoom";
	}
	
	@RequestMapping("b")
	public String toFindingRoom() {
		return "branch/FindingCategoryRoom";
	}
	
	@RequestMapping("c")
	public String toFindingCategoryRoom() {
		return "branch/FindingCategoryRoom";
	}
	
	@RequestMapping("/MeetingAndEventMain")
	public String toMeetingAndEvent() {
		return "event/MeetingAndEventMain";
	}
	
	@RequestMapping("e")
	public String toTranslateLanguage() {
		return "";
	}
	
	
	
}
