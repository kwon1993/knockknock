package com.knockknock.dto.member;

import java.util.Date;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
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
	private String address;
	private String addressDetail;
	private String addressName;
	private String phoneNumber;
	private Date joinTime;
	private Date leaveTime;
	private String imageProfile;
	private String introduce;
}
