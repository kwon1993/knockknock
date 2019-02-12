package com.knockknock.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.service.BranchService;

@Controller
public class BranchController {
	@Autowired
	public BranchService branchService;

	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	// Ajax 방리스트받기(체크박스,주소)
	@PostMapping("/roomSearch")
	@ResponseBody
	public List<BranchDetailVDTO> roomCheckbox(Model model, @RequestBody BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("list", branchService.roomList(branchDetailVDTO));
		return branchService.roomList(branchDetailVDTO);
	}
  
	  //관심사로 방찾기의 방검색
	 @RequestMapping(value="/categoryRoomSearch",method=RequestMethod.POST) 
	 @ResponseBody
	 public String categoryRoomSearch(@RequestParam("address") String address, Model model,@RequestParam List<String>themeCheckboxList)
	 throws Exception { 
	  
		 System.out.println(address+"   "+themeCheckboxList);
		 model.addAttribute("lists", branchService.categoryRoomSearch(address));
	  
	 return "branch/FindingCategoryRoom";
	 }
	 
//	@PostMapping("/categoryRoomSearch")
//	@ResponseBody
//	public List<BranchDetailVDTO>categoryRoomSearch(Model model,@RequestBody BranchDetailVDTO branchDetailVDTO)throws Exception{
//		model.addAttribute("list", branchService.categoryRoomSearch(branchDetailVDTO));
//		
//		return branchService.categoryRoomSearch(branchDetailVDTO);
//	}
	  
	// GET: 파일 업로드 폼이 있는 페이지
	@RequestMapping(value = "roomDetailView", method = RequestMethod.GET)
	public String roomDetailView(@RequestParam("branchNumber") int branchNumber, Model model) {
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfoList", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfoList", branchService.getMemberInfo(branchNumber));

		return "branch/HouseInfo";
	}

	// 업로드 폴더 생성 메서드
	private String getFolder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String str = sdf.format(date);
		return str.replace("-", File.separator);
	}

	// 업로드 파일이 이미지 타입인지 체크하는 메서드
	private boolean checkImageType(File file) {
		try {
			String contentType = Files.probeContentType(file.toPath());

			return contentType.startsWith("image");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	@PostMapping("/uploadAjaxAction")
	@ResponseBody
	public void uploadAjaxPost(MultipartFile[] uploadFile) {

		// 지점 번호 받아서 경로에 넣어주기!
		String uploadFolder = "C:\\Users\\min\\Desktop\\knockknock\\knockknock\\KnockKnock\\src\\main\\resources\\static\\images\\branch";

		// 폴더 생성
		File uploadPath = new File(uploadFolder, getFolder());
		logger.info("upload path: " + uploadPath);

		if (uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}

		for (MultipartFile multipartFile : uploadFile) {
			logger.info("-------------------------------");
			logger.info("Upload File Name: " + multipartFile.getOriginalFilename());
			logger.info("Upload File Size: " + multipartFile.getSize());

			String uploadFileName = multipartFile.getOriginalFilename();

			// IE has file path
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
			logger.info("only file name: " + uploadFileName);

			// 중복 파일 구분을 위한 랜덤 문자열 생성
			UUID uuid = UUID.randomUUID();

			// 언더바로 랜덤 문자열과 본래의 파일명 구분
			uploadFileName = uuid.toString() + "_" + uploadFileName;

			try {
				File saveFile = new File(uploadPath, uploadFileName);
				multipartFile.transferTo(saveFile);

				// 업로드 파일 타입 체크
				/* if(checkImageType(saveFile)) { // 이미지 파일이라면 섬네일 생성
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath, "s_"+uploadFileName));
					
					Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 300, 300);
					
					thumbnail.close();
				}*/
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	// 방문 신청
	@RequestMapping(value = "/visitBooking", method = RequestMethod.POST)
	@ResponseBody
	public void visitBooking(@RequestBody VisitDTO visitDTO,Authentication authentication) {

		// 현재 로그인 사용자 정보에 접근
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String username = user.getUsername();
		
		logger.info(visitDTO.toString());

		logger.info("POST/visitBooking");
		//branchService.visitBooking(visitDTO);
		 branchService.visitBooking(visitDTO, username);
	}

}
