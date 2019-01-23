package com.knockknock.dto.event;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MeetingVDTO {

	private int writingNumber;
	private int memberNumber;
	private String title;
	private Date wirteTime;
	private Date acceptStartTime;
	private Date acceptEndTime;
	private int recruitNumber;
	private int hit;
	private String simpleIntroduce;
	private String detailIntroduce;
	private String place;
	private String placeDetail;
	private String cancelReasin;
	private Date meetingStartDate;
	private Date meetingEndDate;
	private String image;
	private int like;
}