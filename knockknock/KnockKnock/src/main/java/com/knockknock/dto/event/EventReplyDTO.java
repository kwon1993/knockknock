package com.knockknock.dto.event;

import java.sql.Date;
import lombok.Data;

@Data
public class EventReplyDTO {
	private int writingNumber; //댓글달릴 글번호
	private int memberNumber; //댓글쓴 회원번호
	private String content; //댓글 내용
	private Date writeTime; //댓글 작성시간
	private int parentNumber; //대댓글) 부모댓글 번호
}
