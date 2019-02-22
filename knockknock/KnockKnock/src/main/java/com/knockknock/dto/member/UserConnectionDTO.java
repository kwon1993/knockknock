package com.knockknock.dto.member;

import com.knockknock.social.FacebookUserDetails;

import lombok.Data;

@Data
public class UserConnectionDTO {
	public String accessToken;
	public String nickname;
	public String name;
	public String email;
	public long expireTime;
	public String profileUrl;
	public String provider;
	public String providerId;
	public int memberNumber;
	
	private UserConnectionDTO() {
		
	}
	
	public UserConnectionDTO(FacebookUserDetails userDetails) {
		this.accessToken = userDetails.getAccessToken();
		this.nickname = userDetails.getNickname();
		this.name = userDetails.getName();
		this.email = userDetails.getEmail();
		this.expireTime = userDetails.getExpireTime();
		this.profileUrl = userDetails.getProfileUrl();
		this.provider = userDetails.getProvider();
		this.providerId = userDetails.getProviderId();
		this.memberNumber = userDetails.getMemberNumber();
	}
}
