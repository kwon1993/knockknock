package com.knockknock.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.mapper.MeetingAndEventMapper;

@Service("com.knockknock.service.MeetingAndEventServiceImpl")
public class MeetingAndEventServiceImpl {
	
	@Resource(name="com.knockknock.mapper.MeetingAndEventMapper")
	MeetingAndEventMapper meMapper;
	
	public List<MeetingDTO> meetingListService() throws Exception{ //미팅리스트
		return meMapper.meetingList();
	}
	
	public MeetingDTO meetingViewService(int writeNumber) throws Exception{ //미팅상세보기
		return meMapper.meetingView(writeNumber);
	}
	
	public int meetingInsertService(MeetingDTO meetingBoard) throws Exception{ //미팅 작성
		return meMapper.meetingInsert(meetingBoard);
	}

	public int meetingModifyService(MeetingDTO meetingBoard) throws Exception{ //미팅 수정
		return meMapper.meetingModify(meetingBoard);
	}
	
	public int meetingDeleteService(int writeNumber) throws Exception{ //미팅 삭제
		return meMapper.meetingDelete(writeNumber);
	}
}
