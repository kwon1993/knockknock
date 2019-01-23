package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Data;

<<<<<<< HEAD
@Data
=======
@Getter
@Setter
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
public class MeetingDTO {
	private int writingNumber; //글번호
	private int memberNumber; //회원번호
	private String title; //글제목
	private Date writeTime; //작성시간
	private Date acceptStartTime; //모임 모집시작시간
	private Date acceptEndTime; //모임 모집마감시간
	private int recruitNumber; //모집인원
	private int hit; //조회수
	private String simpleIntroduce; //모임 간단소개
	private String detailIntroduce; //모임 상세소개
<<<<<<< HEAD
	private String meetingPlace; //모임 주소
	private String meetingPlaceDetail; //모임 세부주소
=======
	private String place; //모임 주소
	private String placeDetail; //모임 세부주소
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
	private String cancelReason; //취소이유
	private Date meetingStartTime; //모임 시작시간
	private Date meetingEndTime; //모임 종료시간
	private String image; //이미지
	private int like; //좋아요
}
