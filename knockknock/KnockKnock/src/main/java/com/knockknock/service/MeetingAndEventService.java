package com.knockknock.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingVDTO;

public interface MeetingAndEventService {
	public int meetingCountService(Criteria cri) throws Exception; //모임글 수
	public List<MeetingVDTO> mMainListService() throws Exception; //모임글 리스트
	public List<EventVDTO> eMainListService() throws Exception; //모임글 리스트
	public List<MeetingVDTO> meetingListService(Criteria cri) throws Exception; //모임글 리스트
	public MeetingVDTO meetingViewService(int writingNumber) throws Exception; //모임상세보기
	public int meetingInsertService(MeetingVDTO meeting) throws Exception; //모임 글쓰기
	public MeetingVDTO meetingModifyFormService(int writingNumber) throws Exception;
	public void meetingModifyService(MeetingVDTO meeting) throws Exception;
	public int meetingDeleteService(int writingNumber) throws Exception;
	public int meetingSearchService() throws Exception;
	public int eventCountService(Criteria cri) throws Exception;
	public List<EventVDTO> eventListService(Criteria cri) throws Exception;
	public EventVDTO eventViewService(int writingNumber) throws Exception;
	public int eventSearchService() throws Exception;
	public int imageUploadService(MultipartFile image) throws Exception; 
	public MeetingVDTO imageViewService(int writingNumber) throws Exception;
	public int likeToggleService() throws Exception;
	public void mparticipateService(int writingNumber, int memberNumber) throws Exception;
	public void eparticipateService(int writingNumber, int memberNumber) throws Exception;
	public int meetingPlaceService() throws Exception;
	public int meetingPlaceDetailService() throws Exception;
}
