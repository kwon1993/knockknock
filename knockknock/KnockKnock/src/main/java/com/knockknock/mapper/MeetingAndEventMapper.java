package com.knockknock.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.MeetingDTO;

@Repository("com.knockknock.mapper.MeetingAndEventMapper")
public interface MeetingAndEventMapper {
	public int meetingCount() throws Exception; //모임글 수
	public List<MeetingDTO> meetingList() throws Exception; //모임글 리스트
	public MeetingDTO meetingView(int writeNumber) throws Exception; //모임상세보기
	public int meetingInsert(MeetingDTO meetingBoard) throws Exception; //모임 글쓰기
	public int meetingModify(MeetingDTO meetingBoard) throws Exception;
	public int meetingDelete(int writeNumber) throws Exception;
	public int meetingSearch() throws Exception;
	public int eventCount() throws Exception;
	public List<EventDTO> eventList() throws Exception;
	public int eventSearch() throws Exception;
	public int fileUpload() throws Exception;
	public int fileDown() throws Exception;
	public int likeToggle() throws Exception;
	public int participate() throws Exception;
	public int meetingPlace() throws Exception;
	public int meetingPlaceDetail() throws Exception;
	
}
