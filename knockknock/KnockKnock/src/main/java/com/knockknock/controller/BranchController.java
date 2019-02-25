package com.knockknock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.BranchDetailVDTO2;
import com.knockknock.dto.member.LikeBranchDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.security.MemberController;
import com.knockknock.security.MemberService;
import com.knockknock.service.BranchService;

@Controller
public class BranchController {
	@Autowired
	public BranchService branchService;

	@Autowired
	public MemberController mc;

	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	//ajax 방리스트받기(체크박스,주소)
	@RequestMapping("/roomSearch")
	@ResponseBody
	public List<BranchDetailVDTO> roomCheckbox(Model model, @RequestBody BranchDetailVDTO branchDetailVDTO) {

		model.addAttribute("list", branchService.roomList(branchDetailVDTO));
		return branchService.roomList(branchDetailVDTO);
	}
  	 //관심사로 방찾기(체크박스, 주소)
	 @RequestMapping(value="/categoryRoomSearch") 
	 @ResponseBody
	 public List<BranchDetailVDTO> categoryRoomSearch(Model model,@RequestBody BranchDetailVDTO2 data)
	 throws Exception { 
	  
		 System.out.println(data);
		 List<BranchDetailVDTO>  branchDetailVDTOs =branchService.categoryRoomSearch(data);
		 
		  model.addAttribute("lists",branchDetailVDTOs);
		  System.out.println("  branchDetailVDTOs   "+ branchDetailVDTOs);
		 
	 return branchDetailVDTOs;
	 }
	   
	 // 생년월일을 기준으로 현재 나이 계산 
	/*
	 * public int getAge(int birthYear, int birthMonth, int birthDay) { Calendar
	 * current = Calendar.getInstance(); int currentYear =
	 * current.get(Calendar.YEAR); int currentMonth = current.get(Calendar.MONTH) +
	 * 1; int currentDay = current.get(Calendar.DAY_OF_MONTH);
	 * 
	 * int age = currentYear - birthYear; // 생일 안 지난 경우 -1 if (birthMonth * 100 +
	 * birthDay > currentMonth * 100 + currentDay) age--;
	 * 
	 * return age; }
	 */

	// GET: 파일 업로드 폼이 있는 페이지
	@RequestMapping(value = "roomDetailView", method = RequestMethod.GET)
	public String roomDetailView(@RequestParam("branchNumber") int branchNumber, Model model, Authentication authentication, MemberDTO memberDTO, HttpSession hs) {
		mc.getSession(authentication,hs,memberDTO);
		
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfoList", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfoList", branchService.getMemberInfo(branchNumber));
		model.addAttribute("petInfoList", branchService.getPetInfo(branchNumber));
		
		String path;
		String OS = System.getProperty("os.name").toLowerCase();
		if(OS.indexOf("nux") >= 0) {
			path = "/project/knockknock/knockknock/KnockKnock/src/main/resources/static/images/branch/"+branchNumber;
		} else {
			path = System.getProperty("user.dir")+"/src/main/resources/static/images/branch/"+branchNumber;
		}
		
		File f = new File( path );
		File[] files = f.listFiles();

		int count = 0;
		List<String> list = new ArrayList<String>();

		List<String> main = new ArrayList<String>();
		for (int i = 0; i < files.length; i++) {
			if(i < files.length-1) {
				if ( files[i].isFile() ) {
					count++;
					list.add(files[i].getName());
					System.out.println( "파일 : " + files[i].getName() );
				} else {
					System.out.println( "디렉토리명 : " + files[i].getName() );
				}
			} else {
				if( files[i].isFile() ) {
					main.add(files[i].getName());
				}
			}
			
		} // end of for

//		for (int i = 0; i < files.length-1; i++) {
//
//		if ( files[i].isFile() ) {
//		count++;
//		list.add(files[i].getName());
//		System.out.println( "파일 : " + files[i].getName() );
//		} else {
//		System.out.println( "디렉토리명 : " + files[i].getName() );
//		}
//		} 

		System.out.println(list);
		count= count-1;
		System.out.println("파일 갯수: " +count);
		model.addAttribute("fileList", list);
		model.addAttribute("mainImage", main);
		
		String pathRoom;
		if(OS.indexOf("nux") >= 0) {
			pathRoom = "/project/knockknock/knockknock/KnockKnock/src/main/resources/static/images/branch/"+branchNumber+"room";
		} else {
			pathRoom = System.getProperty("user.dir")+"/src/main/resources/static/images/branch/"+branchNumber+"room";
		}
		
		File fRoom = new File( pathRoom );
		File[] filesRoom = fRoom.listFiles();
		
		List<String> roomList = new ArrayList<String>();
		
		for(int i = 0; i < filesRoom.length-1; i++) {
		if(filesRoom[i].isFile()) {
			roomList.add(filesRoom[i].getName());
			System.out.println( "파일 : " + filesRoom[i].getName() );
		} else {
			System.out.println( "디렉토리명 : " + filesRoom[i].getName() );
		}
		}
		System.out.println(roomList);
		model.addAttribute("roomList", roomList);
		
		return "branch/HouseInfo";
	}

	@RequestMapping(value = "/visitBooking", method = RequestMethod.POST)
	@ResponseBody
	public void visitBooking(@RequestBody VisitDTO visitDTO, Authentication authentication) {

		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername();

		logger.info(visitDTO.toString());
		logger.info("POST/visitBooking");

		branchService.visitBooking(visitDTO, email);
	}
	
	@RequestMapping(value="/likeBranch", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void likeBranch(Model model, @RequestBody String branchNumber1, Authentication authentication) {
		
		// System.out.println("likeBranch: "+branchNumber1);
		int branchNumber = Integer.parseInt(branchNumber1);
		
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername();
		
		branchService.likeBranch(branchNumber, email);
	}
	
	@RequestMapping(value="/getHeartStatus", method={RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public LikeBranchDTO getHeartStatus(Model model, @RequestBody String branchNumber1, Authentication authentication) {
		
		System.out.println("하트 상태: "+branchNumber1);
				
		 int branchNumber = Integer.parseInt(branchNumber1);
		 
		 authentication = SecurityContextHolder.getContext().getAuthentication(); 
		 User user = (User) authentication.getPrincipal(); 
		 String email = user.getUsername();
		 
		 System.out.println(branchService.getHeartStatus(branchNumber, email));
		 
		 model.addAttribute("heartStatus", branchService.getHeartStatus(branchNumber, email));
		 return branchService.getHeartStatus(branchNumber, email);

	}
}
