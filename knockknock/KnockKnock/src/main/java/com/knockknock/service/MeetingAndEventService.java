package com.knockknock.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.MeetingVDTO;
import com.knockknock.mapper.MeetingAndEventMapper;

@Service
public class MeetingAndEventService {

	@Autowired
	public MeetingAndEventMapper meMapper;
	
	public void meetingInsert(MeetingVDTO meetingVDTO) {
		meMapper.meetingInsert(meetingVDTO);
	}; //모임 글쓰기
	
	
	public int getWritingNumber(){
		ArrayList<Integer> writingNumber = meMapper.getWritingNumber();
		int maxWritingNumber = Collections.max(writingNumber);
		return maxWritingNumber;
	};
	
	
	public void meetingImageUpload(int writingNumber, MeetingVDTO meetingVDTO) {
	//파일업로드
			String resourceToString;
			String OS = System.getProperty("os.name").toLowerCase();
			if (OS.indexOf("nux") >= 0) {
				resourceToString = "/project/knockknock/knockknock/KnockKnock/src/main/resources/static/images/meeting/"
						+ writingNumber;
			} else {
				resourceToString = System.getProperty("user.dir") + "/src/main/resources/static/images/meeting/"
						+ writingNumber;
			}

			File MeetingUploadPath = new File(resourceToString);

			if (MeetingUploadPath.exists() == false) {
				MeetingUploadPath.mkdirs();
			}

			int Numbering = 0;

			for (MultipartFile multipartFile : meetingVDTO.getImage()) {
//				String extension = multipartFile.getOriginalFilename();
				String uploadFileName;
				if(Numbering == 0) {
					uploadFileName = "mainImage";
					Numbering++;
				} else {
					uploadFileName = Numbering++ + "";
				}
				try {
					File saveFile = new File(MeetingUploadPath, uploadFileName);
					// 경로를 파일화시킨다.(실제파일생성)
					multipartFile.transferTo(saveFile);
					// DB에 저장하기 위해 상대경로명에 유저아이디를 섞은 파일명을 합쳐서 finalImage라는 DB용 경로명을 만든다.
//					String image = uploadFileName;
					// 이미지경로를 저장한다.
//					meMapper.meetingInsert(image, meetingVDTO);
					// 이미지 경로를 불러온다.(뷰에서 받아 쓰기 위한 용도)
//					model.addAttribute("image",memberService.getImageDir(username));
				} catch (Exception e) {
					System.err.println("실패");
					e.printStackTrace();
				} // end catch
			}
	}
	
}
