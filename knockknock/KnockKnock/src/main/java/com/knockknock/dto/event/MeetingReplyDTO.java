package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Data;

@Data
public class MeetingReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
	private Date writeTime;
	private int parentNumber;
}
