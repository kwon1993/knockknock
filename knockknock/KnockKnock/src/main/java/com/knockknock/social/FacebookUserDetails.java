package com.knockknock.social;

import org.springframework.security.oauth2.common.OAuth2AccessToken;

import lombok.Data;

@Data
public class FacebookUserDetails {
	public String accessToken;
	public String nickname;
	public String name;
	public String email;
	public long expireTime;
	public String profileUrl;
	public String provider;
	public String providerId;
	public int memberNumber;
	
	public void setAccessToken(OAuth2AccessToken accessToken) {
		System.out.println("FacebookUserDetails()의 setAccessToken(accessToken)입니다");
		this.accessToken = accessToken.getValue();
		this.expireTime = accessToken.getExpiration().getTime();
	}
}
