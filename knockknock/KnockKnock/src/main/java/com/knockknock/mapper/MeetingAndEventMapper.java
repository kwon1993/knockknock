package com.knockknock.mapper;

import java.lang.reflect.Member;
import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingDTO;
import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.dto.member.MemberDTO;

@Mapper
public interface MeetingAndEventMapper {
	public int meetingCount(Criteria cri) throws Exception; //모임글 수
	public List<MeetingVDTO> mMainList() throws Exception;
	public List<EventVDTO> eMainList() throws Exception;
	public List<MeetingVDTO> meetingList(Criteria cri) throws Exception; //모임글 리스트
	public MeetingVDTO meetingView(int writingNumber) throws Exception; //모임상세보기
	public void meetignViewHit(int writingNumber); //조회수
	public int meetingInsert(MeetingVDTO meeting) throws Exception; //모임 글쓰기
	public MeetingDTO meetingModifyForm(int writingNumber);
	public void meetingModify(int writingNumber, int memberNumber, String title, Date meetingStartTime, Date meetingEndTime,
			Date acceptStartTime, Date acceptEndTime, String detailIntroduce, String place,  String placeDetail,
			int recruitMaxNumber, String favorite) throws Exception;
	public int meetingDelete(int writingNumber) throws Exception;
	public int meetingSearch() throws Exception;
	public int eventCount(Criteria cri) throws Exception;
	public List<EventVDTO> eventList(Criteria cri) throws Exception;
	public EventVDTO eventView(int writingNumber) throws Exception;
	public int eventSearch() throws Exception;
	public int imageUpload(MultipartFile image) throws Exception;
	public MeetingVDTO imageView(int writingNumber) throws Exception;
	public int likeToggle() throws Exception;
	public void mparticipate(int writingNumber, int memberNumber) throws Exception;
	public void eparticipate(int writingNumber, int memberNumber) throws Exception;
	public int meetingPlace() throws Exception;
	public int meetingPlaceDetail() throws Exception;
}
