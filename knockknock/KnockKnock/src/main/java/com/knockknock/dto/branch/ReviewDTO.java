package com.knockknock.dto.branch;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class ReviewDTO {
	
	private int writingNumber;
	private int branchNumber;
	
	private int memberNumber;
	private String content;
	private Date writeTime;
	private String image;
}
