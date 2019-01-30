package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;

@Mapper
public interface MeetingAndEventMapper {
	public int meetingCount(Criteria cri) throws Exception; //모임글 수
	public List<MeetingVDTO> meetingList(Criteria cri) throws Exception; //모임글 리스트
	public MeetingVDTO meetingView(int writingNumber) throws Exception; //모임상세보기
	public int meetingInsert(MeetingDTO meetingBoard) throws Exception; //모임 글쓰기
	public int meetingModify(MeetingDTO meetingBoard) throws Exception;
	public int meetingDelete(int writingNumber) throws Exception;
	public int meetingSearch() throws Exception;
	public int eventCount() throws Exception;
	public List<EventVDTO> eventList() throws Exception;
	public int eventSearch() throws Exception;
	public int fileUpload() throws Exception;
	public int fileDown() throws Exception;
	public int likeToggle() throws Exception;
	public int participate() throws Exception;
	public int meetingPlace() throws Exception;
	public int meetingPlaceDetail() throws Exception;
}
