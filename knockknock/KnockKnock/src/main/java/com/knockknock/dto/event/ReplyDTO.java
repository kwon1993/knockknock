package com.knockknock.dto.event;

import java.sql.Date;

public interface ReplyDTO {
	public int writingNumber();
	public int meetingNumber();
	public String content();
	public Date writeDate();
	public int parentNumber();
}
