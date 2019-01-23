package com.knockknock.dto.event;

import java.sql.Date;

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

	public int getWritingNumber() {
		return writingNumber;
	}

	public void setWritingNumber(int writingNumber) {
		this.writingNumber = writingNumber;
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getWirteTime() {
		return wirteTime;
	}

	public void setWirteTime(Date wirteTime) {
		this.wirteTime = wirteTime;
	}

	public Date getAcceptStartTime() {
		return acceptStartTime;
	}

	public void setAcceptStartTime(Date acceptStartTime) {
		this.acceptStartTime = acceptStartTime;
	}

	public Date getAcceptEndTime() {
		return acceptEndTime;
	}

	public void setAcceptEndTime(Date acceptEndTime) {
		this.acceptEndTime = acceptEndTime;
	}

	public int getRecruitNumber() {
		return recruitNumber;
	}

	public void setRecruitNumber(int recruitNumber) {
		this.recruitNumber = recruitNumber;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getSimpleIntroduce() {
		return simpleIntroduce;
	}

	public void setSimpleIntroduce(String simpleIntroduce) {
		this.simpleIntroduce = simpleIntroduce;
	}

	public String getDetailIntroduce() {
		return detailIntroduce;
	}

	public void setDetailIntroduce(String detailIntroduce) {
		this.detailIntroduce = detailIntroduce;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPlaceDetail() {
		return placeDetail;
	}

	public void setPlaceDetail(String placeDetail) {
		this.placeDetail = placeDetail;
	}

	public String getCancelReasin() {
		return cancelReasin;
	}

	public void setCancelReasin(String cancelReasin) {
		this.cancelReasin = cancelReasin;
	}

	public Date getMeetingStartDate() {
		return meetingStartDate;
	}

	public void setMeetingStartDate(Date meetingStartDate) {
		this.meetingStartDate = meetingStartDate;
	}

	public Date getMeetingEndDate() {
		return meetingEndDate;
	}

	public void setMeetingEndDate(Date meetingEndDate) {
		this.meetingEndDate = meetingEndDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

}
