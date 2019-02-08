package com.knockknock.dto.event;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class photoUploadDTO {
	private MultipartFile fileData;
	//콜백 url
	private String callback;
	//콜백함수
	private String callbackFunc;
}
