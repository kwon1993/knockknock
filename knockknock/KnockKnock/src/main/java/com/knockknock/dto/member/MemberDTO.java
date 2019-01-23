package com.knockknock.dto.member;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	
	private int memberNumber;
	private String grade;
	private String favorite1;
	private String favorite2;
	private String favorite3;
	private String email;
	private String password;
	private String name;
	private String nickname;
	private Date birth;
	private String gender;
	private String adress;
	private String addressDetail;
	private String addressName;
	private String phoneNumber;
	private Date joinTime;
	private Date leaveTime;
	private String imageProfile;
	private String intriduce;

}
