package com.knockknock.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;
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
	public List<MeetingVDTO> mMainListService() throws Exception{ //미팅리스트
		return meMapper.mMainList();
	}
	
	@Override
	public List<EventVDTO> eMainListService() throws Exception{ //미팅리스트
		return meMapper.eMainList();
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
	public int meetingInsertService(MeetingVDTO meeting) throws Exception{ //미팅 작성
		return meMapper.meetingInsert(meeting);
	}
	
	@Override
	public MeetingVDTO meetingModifyFormService(int writingNumber) {
		return meMapper.meetingModifyForm(writingNumber);
	}
	
	@Override
	public void meetingModifyService(MeetingVDTO meeting) throws Exception{ //미팅 수정
		meMapper.meetingModify(meeting);
	}
	
	@Override
	public int meetingDeleteService(int writingNumber) throws Exception{ //미팅 삭제
		return meMapper.meetingDelete(writingNumber);
	}
	
	@Override
	public List<EventVDTO> eventListService(Criteria cri) throws Exception{
		return meMapper.eventList(cri);
	}
	
	@Override
	public EventVDTO eventViewService(int writingNumber) throws Exception{ //이벤트 상세보기
		return meMapper.eventView(writingNumber);
	}

	@Override
	public int meetingSearchService() throws Exception {
		return 0;
	}

	@Override
	public int eventCountService(Criteria cri) throws Exception {
		return meMapper.eventCount(cri);
	}

	@Override
	public int eventSearchService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int imageUploadService(MultipartFile image) throws Exception {
		return meMapper.imageUpload(image);
	}
	@Override
	public MeetingVDTO imageViewService(int writingNumber) throws Exception {
		return meMapper.imageView(writingNumber);
	}

	@Override
	public int likeToggleService() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void mparticipateService(int writingNumber, int memberNumber) throws Exception {
		meMapper.mparticipate(writingNumber, memberNumber);
	}
	
	@Override
	public void eparticipateService(int writingNumber, int memberNumber) throws Exception {
		meMapper.eparticipate(writingNumber, memberNumber);
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
