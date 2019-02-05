package com.knockknock.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.mapper.MeetingAndEventMapper;

@Service
public class MeetingAndEventServiceImpl implements MeetingAndEventService{
		
	@Autowired
	MeetingAndEventMapper meMapper;
	
	@Override
	public int meetingCountService(Criteria cri) throws Exception {
		return meMapper.meetingCount(cri);
	}
	
	@Override
	public List<MeetingVDTO> meetingListService(Criteria cri) throws Exception{ //미팅리스트
		return meMapper.meetingList(cri);
	}
	
	@Override
	public MeetingVDTO meetingViewService(int writingNumber) throws Exception{ //미팅상세보기
		return meMapper.meetingView(writingNumber);
	}
	
	@Override
	public void meetingInsertService(int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String simpleIntroduce, String detailIntroduce,
			String place, String placeDetail, int recruitMaxNumber, String gender) throws Exception{ //미팅 작성
		meMapper.meetingInsert( memberNumber,  title,  meetingStartTime,  meetingEndTime,
			 acceptStartTime,  acceptEndTime,  simpleIntroduce,  detailIntroduce,
			 place,  placeDetail,  recruitMaxNumber, gender);
	}
	
	@Override
	public MeetingDTO meetingModifyFormService(int writingNumber) {
		return meMapper.meetingModifyForm(writingNumber);
	}
	
	@Override
	public void meetingModifyService(int writingNumber, int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String simpleIntroduce, String detailIntroduce,
			String place, String placeDetail, int recruitMaxNumber) throws Exception{ //미팅 수정
		meMapper.meetingModify(writingNumber, memberNumber,  title,  meetingStartTime,  meetingEndTime,
				 acceptStartTime,  acceptEndTime,  simpleIntroduce,  detailIntroduce,
				 place,  placeDetail, recruitMaxNumber);
	}
	
	@Override
	public int meetingDeleteService(int writingNumber) throws Exception{ //미팅 삭제
		return meMapper.meetingDelete(writingNumber);
	}
	
	@Override
	public List<EventVDTO> eventListService() throws Exception{
		return meMapper.eventList();
	}

	@Override
	public int meetingSearchService() throws Exception {
		return 0;
	}

	@Override
	public int eventCountService() throws Exception {
		return 0;
	}

	@Override
	public int eventSearchService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fileUploadService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int fileDownService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int likeToggleService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void participateService(int writingNumber, int memberNumber) throws Exception {
		meMapper.participate(writingNumber, memberNumber);
	}

	@Override
	public int meetingPlaceService() throws Exception {
		return 0;
	}

	@Override
	public int meetingPlaceDetailService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
