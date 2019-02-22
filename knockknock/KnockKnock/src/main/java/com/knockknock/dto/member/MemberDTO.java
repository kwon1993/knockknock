package com.knockknock.dto.member;

import java.util.Date;
import lombok.Data;

@Data
public class MemberDTO{
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
	private String address;
	private String addressDetail;
	private String addressName;
	private String phoneNumber;
	private Date joinTime;
	private Date leaveTime;
	private String imageProfile;
	private String introduce;
	//임시추가(from 성현)
	private String animal;
	//소셜용
	public String provider;
	private String providerId;
	

   
}