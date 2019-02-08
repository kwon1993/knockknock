package com.knockknock.mapper;

import java.sql.Date;
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
	public void meetignViewHit(int writingNumber); //조회수
	public void meetingInsert(int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String simpleIntroduce, String detailIntroduce,
			String place, String placeDetail, int recruitMaxNumber, String gender, String favorite) throws Exception; //모임 글쓰기
	public MeetingDTO meetingModifyForm(int writingNumber);
	public void meetingModify(int writingNumber, int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String simpleIntroduce, String detailIntroduce,
			String place, String placeDetail, int recruitMaxNumber) throws Exception;
	public int meetingDelete(int writingNumber) throws Exception;
	public int meetingSearch() throws Exception;
	public int eventCount() throws Exception;
	public List<EventVDTO> eventList() throws Exception;
	public int eventSearch() throws Exception;
	public int fileDown() throws Exception;
	public int likeToggle() throws Exception;
	public void participate(int writingNumber, int memberNumber) throws Exception;
	public int meetingPlace() throws Exception;
	public int meetingPlaceDetail() throws Exception;
}
