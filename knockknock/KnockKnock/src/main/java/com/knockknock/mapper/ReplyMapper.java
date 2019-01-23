package com.knockknock.mapper;

import java.util.List;

import com.knockknock.dto.event.EventReplyDTO;
import com.knockknock.dto.event.MeetingReplyDTO;
<<<<<<< HEAD
import com.knockknock.dto.event.ReplyDTO;
=======
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db

public interface ReplyMapper {
	public int replyWritingNumber() throws Exception;
	public int replyInsert() throws Exception;
<<<<<<< HEAD
	public List<ReplyDTO> replyList() throws Exception;
=======
	public List<MeetingReplyDTO> meetingReplyList() throws Exception;
	public List<EventReplyDTO> eventReplyList() throws Exception;
>>>>>>> a26fd36b2e4ad7887e95e867c2311f30ec9020db
	public int replyDelete() throws Exception;
	public int replyUpdate() throws Exception;
}
