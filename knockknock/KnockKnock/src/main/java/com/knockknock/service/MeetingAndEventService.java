package com.knockknock.service;

import java.sql.Date;
import java.util.List;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
public interface MeetingAndEventService {
	public int meetingCountService(Criteria cri) throws Exception; //모임글 수
	public List<MeetingVDTO> meetingListService(Criteria cri) throws Exception; //모임글 리스트
	public MeetingVDTO meetingViewService(int writingNumber) throws Exception; //모임상세보기
	public void meetingInsertService(int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String simpleIntroduce, String detailIntroduce,
			String place, String placeDetail, int recruitMaxNumber, String gender, String favorite) throws Exception; //모임 글쓰기
	public void meetingModifyService(int writingNumber, int memberNumber, String title, Date meetingStartTime, 
			Date meetingEndTime, Date acceptStartTime, Date acceptEndTime, String simpleIntroduce,
			String detailIntroduce, String place, String placeDetail, int recruitMaxNumber) throws Exception;
	public MeetingDTO meetingModifyFormService(int writingNumber) throws Exception;
	public int meetingDeleteService(int writingNumber) throws Exception;
	public int meetingSearchService() throws Exception;
	public int eventCountService() throws Exception;
	public List<EventVDTO> eventListService() throws Exception;
	public int eventSearchService() throws Exception;
	public int fileUploadService() throws Exception;
	public int fileDownService() throws Exception;
	public int likeToggleService() throws Exception;
	public void participateService(int writingNumber, int memberNumber) throws Exception;
	public int meetingPlaceService() throws Exception;
	public int meetingPlaceDetailService() throws Exception;
}
