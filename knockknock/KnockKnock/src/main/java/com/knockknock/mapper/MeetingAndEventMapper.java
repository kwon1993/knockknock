package com.knockknock.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.event.MeetingVDTO;

@Mapper
public interface MeetingAndEventMapper {
	//meeeting
	public int meetingCount(Criteria cri) ; //모임글 수
	public List<MeetingVDTO> mMainList() ; //메인페이지 모임리스트
	public List<MeetingVDTO> meetingList(Criteria cri) ; //모임글 리스트
	public MeetingVDTO meetingView(int writingNumber) ; //모임상세보기
	public void meetignViewHit(int writingNumber); //조회수
	public ArrayList<Integer> getWritingNumber();  //모임 글 번호 가져오기
	public void meetingInsert(MeetingVDTO meetingVDTO) ; //모임 글쓰기
	public MeetingVDTO meetingModifyForm(int writingNumber);
	public int meetingModify(MeetingVDTO meeting) ; //모임 수정
	public int meetingDelete(int writingNumber) ; //모임 취소
	public int meetingSearch() ; //관심사로 검색하기
	public void mparticipate(@Param("meetingVDTO") MeetingVDTO meetingVDTO, String email) ; //모임 참가하기
	public void mpartNumUp(@Param("meetingVDTO") MeetingVDTO meetingVDTO); //모임인원 갱신
	public int meetingPlace() ;
	public int meetingPlaceDetail() ;
	
	//event
	public int eventCount(Criteria cri) ;
	public List<EventVDTO> eMainList() ; //메인페이지 이벤트리스트
	public List<EventVDTO> eventList(Criteria cri) ;
	public EventVDTO eventView(int writingNumber) ;
	public int eventSearch() ;
	public void eparticipate(@Param("eventVDTO") EventVDTO eventVDTO, String email) ;
	
	//기타
	public int imageUpload(MultipartFile meetingImage) ;
	public MeetingVDTO imageView(int writingNumber) ;
	public int likeToggle() ;
}
