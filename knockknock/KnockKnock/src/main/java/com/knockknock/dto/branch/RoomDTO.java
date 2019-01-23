package com.knockknock.dto.branch;

import java.sql.Date;

import lombok.Data;

@Data
public class RoomDTO {
	private int roomNumber;
	private int branchNumber;
	private String gender;
	private int allowNumber;
	private String space;
	private int deposit;
	private int monthlyRent;
	private Date rentableDate;
	private String facility;
	private String imageRoom;
}