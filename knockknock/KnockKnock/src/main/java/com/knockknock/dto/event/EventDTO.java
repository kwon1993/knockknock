package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Data;

@Data
public class EventDTO {
	private int writingNumber; //글번호
	private int memberNumber; //회원번호
	private String title; //글제목
	private int hit; //조회수
	private Date writeTime; //작성시간
	private String content; //글내용
	private Date acceptStartTime; //모임 모집시작시간
	private Date acceptEndTime; //모임 모집마감시간
	private String cancelReason; //취소이유
	private int recruitNumber; //모집인원
	private Date eventStartTime; //모임 시작시간
	private Date eventEndTime; //모임 종료시간
	private String image; //이미지
	private int like; //좋아요
}
<<<<<<< HEAD

=======
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
