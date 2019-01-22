package com.knockknock.mapper;

import java.util.List;

import com.knockknock.dto.event.ReplyDTO;

public interface ReplyMapper {
	public int replyWritingNumber() throws Exception;
	public int replyInsert() throws Exception;
	public List<ReplyDTO> replyList() throws Exception;
	public int replyDelete() throws Exception;
	public int replyUpdate() throws Exception;
}
