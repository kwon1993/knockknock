package com.knockknock.mapper;

import java.util.List;

import com.knockknock.dto.event.EventReplyDTO;
import com.knockknock.dto.event.MeetingReplyDTO;

public interface ReplyMapper {
	public int replyWritingNumber() throws Exception;
	public int replyInsert() throws Exception;
	public List<MeetingReplyDTO> meetingReplyList() throws Exception;
	public List<EventReplyDTO> eventReplyList() throws Exception;
	public int replyDelete() throws Exception;
	public int replyUpdate() throws Exception;
}
