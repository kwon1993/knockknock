package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingVDTO;

@Mapper
public interface MeetingAndEventMapper {
	public int meetingCount(Criteria cri) ; //모임글 수
	public List<MeetingVDTO> mMainList() ;
	public List<EventVDTO> eMainList() ;
	public List<MeetingVDTO> meetingList(Criteria cri) ; //모임글 리스트
	public MeetingVDTO meetingView(int writingNumber) ; //모임상세보기
	public void meetignViewHit(int writingNumber); //조회수
	public int meetingInsert(MeetingVDTO meeting) ; //모임 글쓰기
	public MeetingVDTO meetingModifyForm(int writingNumber);
	public int meetingModify(MeetingVDTO meeting) ;
	public int meetingDelete(int writingNumber) ;
	public int meetingSearch() ;
	public int eventCount(Criteria cri) ;
	public List<EventVDTO> eventList(Criteria cri) ;
	public EventVDTO eventView(int writingNumber) ;
	public int eventSearch() ;
	public int imageUpload(MultipartFile image) ;
	public MeetingVDTO imageView(int writingNumber) ;
	public int likeToggle() ;
	public void mparticipate(@Param("meetingVDTO") MeetingVDTO meetingVDTO, String email) ;
	public void eparticipate(@Param("eventVDTO") EventVDTO eventVDTO, String email) ;
	public int meetingPlace() ;
	public int meetingPlaceDetail() ;
}
