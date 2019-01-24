package com.knockknock.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.service.MeetingAndEventServiceImpl;

public class MeetingAndEventController {
//	@Resource(name = "com.knockknock.service.MeetingAndEventServiceImpl")
	@Autowired
	MeetingAndEventServiceImpl meServiceImpl;
	
	@RequestMapping("MeetingList") //미팅리스트
	private String meetingList(Model model) throws Exception{
		model.addAttribute("meetingList", meServiceImpl.meetingListService());
		return "meetingList";
	}
	
	@RequestMapping("MeetingView/{writeNum}") //미팅 상세보기
	private String meetingView(@PathVariable int writeNum, Model model) throws Exception {
		model.addAttribute("meetingView", meServiceImpl.meetingViewService(writeNum));
		return "meetingView";
	}
	
	@RequestMapping("WriteBoard") //미팅 글 쓰기
	private String writeBoardForm() {
		return "writeBoard";
	}
}