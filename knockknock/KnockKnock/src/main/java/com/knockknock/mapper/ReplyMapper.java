package com.knockknock.mapper;

import java.util.List;

import com.knockknock.dto.event.EventReplyDTO;
import com.knockknock.dto.event.MeetingReplyDTO;
import com.knockknock.dto.event.ReplyDTO;
<<<<<<< HEAD
=======

>>>>>>> efbb975837f57fe3d8cd73ab81b864860e86518d

public interface ReplyMapper {
	public int replyWritingNumber() throws Exception;
	public int replyInsert() throws Exception;
	public List<ReplyDTO> replyList() throws Exception;
	public List<MeetingReplyDTO> meetingReplyList() throws Exception;
	public List<EventReplyDTO> eventReplyList() throws Exception;
	public int replyDelete() throws Exception;
	public int replyUpdate() throws Exception;
}
