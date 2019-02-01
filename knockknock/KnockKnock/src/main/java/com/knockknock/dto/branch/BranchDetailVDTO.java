package com.knockknock.dto.branch;

import java.sql.Date;

import lombok.Data;

@Data
public class BranchDetailVDTO {
	
	private int branchNumber;
	private String theme;
	private String gender;
	private String branchComment;
	private String address;
	private String addressDetail;
	private String branchType;
	private String isParking;
	private String isElevator;
	private String facility;
	private String pet;
	private int maximumResident;
	private String rule;
	private String imageLiving;
	private String imageKitchen;
	private String imageBathroom;
	private String imageETC;
	private int roomNumber;
	private int allowNuber;
	private String space;
	private int deposit;
	private int monthlyRent;
	private Date rentableDate;
	private String imageRoom;
	private String nickname;
	private int memberNumber;
	private String comment;
	private Date writeTime;
	private String image;
	private String animal;
	/* private int petNumber; */
	private int amount;
	private int writingNumber;
	
	private String favorite1;
	private String favorite2;
	private String favorite3;
	private Date birth;
	private String memberGender;
	private String introduce;
}
