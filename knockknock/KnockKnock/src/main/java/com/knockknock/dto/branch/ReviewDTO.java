package com.knockknock.dto.branch;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
	
	private int writingNumber;
	private int memberNumber;
	private int branchNumber;
	private String content;
	private Date writeTime;
	private String image;
}
