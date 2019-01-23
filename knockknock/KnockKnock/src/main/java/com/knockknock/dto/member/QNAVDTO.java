package com.knockknock.dto.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QNAVDTO {
	
	private int writingNumber;
	private int memberNumber;
	private String category;
	private String title;
	private Date writeTime;
	private String content;
	private String reply;
	private String nickname;
}
