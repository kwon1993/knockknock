package com.knockknock.service;

import java.util.List;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
public interface MeetingAndEventService {
	//public int meetingCountService() throws Exception; //모임글 수
	public List<MeetingVDTO> meetingListService() throws Exception; //모임글 리스트
	public MeetingDTO meetingViewService(int writeNum) throws Exception; //모임상세보기
	public int meetingInsertService(MeetingDTO meetingBoard) throws Exception; //모임 글쓰기
	public int meetingModifyService(MeetingDTO meetingBoard) throws Exception;
	public int meetingDeleteService(int writeNum) throws Exception;
	public int meetingSearchService() throws Exception;
	public int eventCountService() throws Exception;
	public List<EventVDTO> eventListService() throws Exception;
	public int eventSearchService() throws Exception;
	public int fileUploadService() throws Exception;
	public int fileDownService() throws Exception;
	public int likeToggleService() throws Exception;
	public int participateService() throws Exception;
	public int meetingPlaceService() throws Exception;
	public int meetingPlaceDetailService() throws Exception;
}
