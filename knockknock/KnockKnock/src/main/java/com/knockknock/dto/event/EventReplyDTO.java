package com.knockknock.dto.event;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EventReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
	private Date writeDate;
	private int parentNumber;
}
