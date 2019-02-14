package com.knockknock.controller;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.event.PageMaker;
import com.knockknock.dto.member.MemberDTO;
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
	
	@Value("${file.upload.directory}")
	String uploadFileDir;
	
	@RequestMapping("/writeBoard") //미팅 글 쓰기
	private String writeBoard(@RequestParam("memberNumber") int memberNumber,
			@RequestParam("title") String title, @RequestParam("meetingStartTime") Date meetingStartTime, @RequestParam("meetingEndTime") Date meetingEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail, @RequestParam("favorite") String favorite,
			@RequestParam("recruitMaxNumber") int recruitMaxNumber, @RequestParam("detailIntroduce") String detailIntroduce
			)throws Exception{/*@RequestPart MultipartFile image*/
		
		MeetingVDTO meeting = new MeetingVDTO();
		meeting.setMemberNumber(memberNumber);
		meeting.setTitle(title);
		meeting.setMeetingStartTime(meetingStartTime);
		meeting.setMeetingEndTime(meetingEndTime);
		meeting.setAcceptStartTime(acceptStartTime);
		meeting.setAcceptEndTime(acceptEndTime);
		meeting.setPlace(place);
		meeting.setPlaceDetail(placeDetail);
		meeting.setFavorite(favorite);
		meeting.setRecruitMaxNumber(recruitMaxNumber);
		meeting.setDetailIntroduce(detailIntroduce);
		
//		if(image.isEmpty()){ //이미지 업로드가 없을때
			meServiceImpl.meetingInsertService(meeting);
//		}else {
//			String ImageName = image.getOriginalFilename(); //파일의 이름을 함수에 저장
////			String ImageNameExtension = FilenameUtils.getExtension(ImageName).toLowerCase();
//			File FileUrl; //경로와 이미지 이름이 섞일 함수선언
//			
//			do {
//				FileUrl = new File(uploadFileDir+ImageName); //경로+이미지
//			}while(FileUrl.exists());
//				
//			FileUrl.getParentFile().mkdirs();
//			image.transferTo(FileUrl);
//			
//			meeting.setImage(FileUrl);
//			
//			meServiceImpl.meetingInsertService(meeting); //게시글 insert
//			meServiceImpl.imageUploadService(image); //이미지 insert
//		}
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
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail, @RequestParam("favorite") String favorite,
			@RequestParam("recruitMaxNumber") int recruitMaxNumber, @RequestParam("detailIntroduce") String detailIntroduce) throws Exception{
		meServiceImpl.meetingModifyService(writingNumber, memberNumber, title, meetingStartTime, meetingEndTime,
				acceptStartTime, acceptEndTime, detailIntroduce, place, placeDetail, recruitMaxNumber, favorite);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/meetingDelete") //미팅 글 삭제
	private String meetingDelete(@RequestParam("writingNumber") int writingNumber) throws Exception{
		meServiceImpl.meetingDeleteService(writingNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/eventList") //이벤트 리스트
	private String eventList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		model.addAttribute("EventList", meServiceImpl.eventListService(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(meServiceImpl.eventCountService(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "event/EventList";
	}
	
	@RequestMapping("/eventView") //미팅 상세보기
	private String eventView(@RequestParam("writingNumber") int writingNumber, Model model) throws Exception {
		model.addAttribute("EventView", meServiceImpl.eventViewService(writingNumber));

		return "event/EventView";
	}
	
	@RequestMapping("/mparticipate") //참가하기
	private String mparticipate(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber) throws Exception{
		meServiceImpl.mparticipateService(writingNumber, memberNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/eparticipate") //참가하기
	private String eparticipate(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber) throws Exception{
		meServiceImpl.eparticipateService(writingNumber, memberNumber);
		return "redirect:/eventList";
	}
	
	@RequestMapping("/cal") //미팅 글 쓰기
	private String cal() throws Exception{
		return "/fullcalendar/demos/agenda-views";
	}
	
}