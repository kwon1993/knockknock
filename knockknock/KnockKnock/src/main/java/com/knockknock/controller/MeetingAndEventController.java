package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.member.MemberDTO;
import com.knockknock.service.MeetingAndEventServiceImpl;

@Controller
public class MeetingAndEventController {
	@Autowired
	MeetingAndEventServiceImpl meServiceImpl;
	
	@RequestMapping("/MeetingList") //미팅리스트
	private String meetingList(Model model, MemberDTO memberDTO) throws Exception{
		model.addAttribute("MeetingList", meServiceImpl.meetingListService());
		return "event/MeetingList";
	}
	
	@RequestMapping("/MeetingView/{writeNum}") //미팅 상세보기
	private String meetingView(@PathVariable int writeNum, Model model) throws Exception {
		model.addAttribute("MeetingView", meServiceImpl.meetingViewService(writeNum));
		return "event/MeetingView";
	}
	
	@RequestMapping("/WriteBoard") //미팅 글 쓰기
	private String writeBoardForm() {
		return "event/WriteBoard";
	}
	
	@RequestMapping("/EventList") //이벤트 리스트
	private String eventList(Model model) throws Exception{
		model.addAttribute("EventList", meServiceImpl.eventListService());
		return "event/EventList";
	}
}