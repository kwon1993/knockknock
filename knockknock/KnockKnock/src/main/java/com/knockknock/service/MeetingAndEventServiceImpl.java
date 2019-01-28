package com.knockknock.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.mapper.MeetingAndEventMapper;

@Service
public class MeetingAndEventServiceImpl implements MeetingAndEventService{
		
	@Autowired
	MeetingAndEventMapper meMapper;
	
	@Override
	public List<MeetingVDTO> meetingListService() throws Exception{ //미팅리스트
		return meMapper.meetingList();
	}
	
	@Override
	public MeetingDTO meetingViewService(int writeNum) throws Exception{ //미팅상세보기
		return meMapper.meetingView(writeNum);
	}
	
	@Override
	public int meetingInsertService(MeetingDTO meetingBoard) throws Exception{ //미팅 작성
		return meMapper.meetingInsert(meetingBoard);
	}
	
	@Override
	public int meetingModifyService(MeetingDTO meetingBoard) throws Exception{ //미팅 수정
		return meMapper.meetingModify(meetingBoard);
	}
	
	@Override
	public int meetingDeleteService(int writeNum) throws Exception{ //미팅 삭제
		return meMapper.meetingDelete(writeNum);
	}
	
	@Override
	public List<EventDTO> eventListService() throws Exception{
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
	public int participateService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int meetingPlaceService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int meetingPlaceDetailService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}




}
