package com.knockknock.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.PageMaker;
import com.knockknock.service.MeetingAndEventServiceImpl;

@Controller
public class MeetingAndEventController {
	@Autowired
	MeetingAndEventServiceImpl meServiceImpl;
	
	@RequestMapping("/meetingList") //미팅리스트
	private String meetingList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		model.addAttribute("MeetingList", meServiceImpl.meetingListService(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(meServiceImpl.meetingCountService(cri));
		
		model.addAttribute("pageMaker", pageMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "event/MeetingList";
	}
	
	@RequestMapping("/meetingView") //미팅 상세보기
	private String meetingView(@RequestParam("writingNumber") int writingNumber, Model model) throws Exception {
		model.addAttribute("MeetingView", meServiceImpl.meetingViewService(writingNumber));
		return "event/MeetingView";
	}
	
	@RequestMapping("/writeBoardForm") //미팅 글 쓰기
	private String writeBoardForm() throws Exception{
		return "event/WriteBoard";
	}
	
	@RequestMapping("/writeBoard") //미팅 글 쓰기
	private String writeBoard(@RequestParam("memberNumber") int memberNumber, @RequestParam("title") String title,
			@RequestParam("meetingStartTime") Date meetingStartTime, @RequestParam("meetingEndTime") Date meetingEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail,
			@RequestParam("recruitNumber") int recruitNumber, @RequestParam("simpleIntroduce") String simpleIntroduce,
			@RequestParam("detailIntroduce") String detailIntroduce) throws Exception{
		
		meServiceImpl.meetingInsertService(memberNumber, title, meetingStartTime, meetingEndTime, acceptStartTime,
				acceptEndTime, simpleIntroduce, detailIntroduce, place, placeDetail, recruitNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/meetingModifyForm")
	private String meetingModifyForm(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("meetingModifyForm", meServiceImpl.meetingModifyFormService(writingNumber));
		return "event/meetingModify";
	}
	
	@RequestMapping("/meetingModify")
	private String meetingModify(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber,
			@RequestParam("title") String title,
			@RequestParam("meetingStartTime") Date meetingStartTime, @RequestParam("meetingEndTime") Date meetingEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail,
			@RequestParam("recruitNumber") int recruitNumber, @RequestParam("simpleIntroduce") String simpleIntroduce,
			@RequestParam("detailIntroduce") String detailIntroduce) throws Exception{
		meServiceImpl.meetingModifyService(writingNumber, memberNumber, title, meetingStartTime, meetingEndTime,
				acceptStartTime, acceptEndTime, simpleIntroduce, detailIntroduce, place, placeDetail, recruitNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/meetingDelete") //미팅 글 삭제
	private String meetingDelete(@RequestParam("writingNumber") int writingNumber) throws Exception{
		meServiceImpl.meetingDeleteService(writingNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/eventList") //이벤트 리스트
	private String eventList(Model model) throws Exception{
		model.addAttribute("EventList", meServiceImpl.eventListService());
		return "event/EventList";
	}
}