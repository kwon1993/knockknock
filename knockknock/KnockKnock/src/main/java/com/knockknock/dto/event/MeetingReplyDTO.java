package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Data;

@Data
public class MeetingReplyDTO {
	private int replyNumber;
	private int writingNumber;
	private int memberNumber;
	private String content;
<<<<<<< HEAD
	private Date writeDate;
=======
	private Date writeTime;
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
	private int parentNumber;
}
