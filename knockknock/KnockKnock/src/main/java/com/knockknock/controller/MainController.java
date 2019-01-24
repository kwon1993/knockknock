package com.knockknock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String start() {
		return "etc/index";
	}
	
	@RequestMapping("a")
	public String simpleRoomSearch() {
		return "branch/FindingRoom";
	}
	
	@RequestMapping("b")
	public String toFindingRoom() {
		return "branch/FindingRoom";
	}
	
	@RequestMapping("c")
	public String toFindingCategoryRoom() {
		return "branch/FindingCategoryRoom";
	}
	
	@RequestMapping("d")
	public String toMeetingAndEvent() {
		return "event/?????";
	}
	
	@RequestMapping("e")
	public String toTranslateLanguage() {
		return "";
	}
	
	
	
}
