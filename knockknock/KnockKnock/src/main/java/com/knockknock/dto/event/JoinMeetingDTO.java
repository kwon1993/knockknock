package com.knockknock.dto.event;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JoinMeetingDTO {
	private int writingNumber; //글 번호
	private int memberNumber; //회원번호
	private String meetingStatus; //
}
