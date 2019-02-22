package com.knockknock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.mapper.MeetingAndEventMapper;
import com.knockknock.mapper.MemberMapper;
import com.knockknock.security.MemberController;
import com.knockknock.service.BranchService;
import com.knockknock.social.SocialService;

@Controller
public class MainController {

	@Autowired
	BranchService branchService;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	MeetingAndEventMapper meMapper;
	@Autowired
	MemberController mc;

	@Autowired
	OAuth2ClientContext oauth2ClientContext;
	
	//메인화면 스타트
	@RequestMapping("/")
	public String start(Model model, MemberDTO memberDTO, BranchDetailVDTO branchDetailVDTO, Authentication authentication, HttpSession hs) {
		
		List temp = branchService.findingRoomList(branchDetailVDTO);
		BranchDetailVDTO mainBranch1 = (BranchDetailVDTO)temp.get(temp.size()-1);
		BranchDetailVDTO mainBranch2 = (BranchDetailVDTO)temp.get(temp.size()-2);
		BranchDetailVDTO mainBranch3 = (BranchDetailVDTO)temp.get(temp.size()-3);
		
		model.addAttribute("mb1",mainBranch1);
		model.addAttribute("mb2",mainBranch2);
		model.addAttribute("mb3",mainBranch3);
		
		//소셜로그인모드면
		if(oauth2ClientContext.getAccessToken()!=null) {
			//소셜로그인 모드면 + 인증이 되었으면
			authentication = SecurityContextHolder.getContext().getAuthentication();
			MemberDTO sc = (MemberDTO)authentication.getPrincipal();
			MemberDTO nickname = memberMapper.findByEmail(sc); 
			
			if(nickname.getProvider()!=null){
				mc.getSocialSession(authentication,hs,memberDTO);
				System.out.println("로그인 되었다");
				return "home/Home";
			}
			else {
				return "redirect:/chuga";
			}
		}
		mc.getSession(authentication,hs,memberDTO);
		return "home/Home";
	}
	
	@RequestMapping("/chuga")
	public String chuga(Model model) {
		return "member/suvRegister";
	}
	
	//메인화면 심플방검색
	@GetMapping("/simpleRoomSearch")
	public String simpleRoomSearch(Model model, BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("lists", branchService.findingRoomList(branchDetailVDTO));
		return "branch/FindingRoom";
	}
	
	//네비게이션바 '방찾기'
	@RequestMapping("/findingRoom")
	public String toFindingRoom(Model model, BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("lists", branchService.findingRoomList(branchDetailVDTO));
		return "branch/FindingRoom";
	}
	
	//네비게이션바 '카테고리로 방찾기'
	@RequestMapping("/findingCategoryRoom")
	public String toFindingCategoryRoom(Model model, BranchDetailVDTO branchDetailVDTO) throws Exception {
		model.addAttribute("lists", branchService.findingCategoryRoomList(branchDetailVDTO));
		model.addAttribute("themeLists", branchService.getThemeLists());
		model.addAttribute("pet", branchService.getIspet());
		model.addAttribute("branchType", branchService.getBranchType());
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(branchService.categoryCountService(cri));
//		
//		model.addAttribute("pageMaker", pageMaker);
		return "branch/FindingCategoryRoom";
	}
	
//	@RequestMapping(value ="/findingCategoryRoom", method=RequestMethod.GET)
//	public String toFindingCategoryRoom(Model model, Criteria cri) throws Exception {
//		model.addAttribute("lists", branchService.findingCategoryRoomList(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		pageMaker.setTotalCount(branchService.categoryCountService(cri));
//		
//		model.addAttribute("pageMaker", pageMaker);
//		return "branch/FindingCategoryRoom";
//	}
	

//	@RequestMapping(value ="/findingCategoryRoom", method=RequestMethod.GET)
//	public String toFindingCategoryRoom(Model model, Criteria cri) throws Exception {
//
//		//model.addAttribute("lists", branchService.findingCategoryRoomList(cri));
//		PageMaker pageMaker = new PageMaker();
//		pageMaker.setCri(cri);
//		//pageMaker.setTotalCount(branchService.categoryCountService(cri));
//		
//		model.addAttribute("pageMaker", pageMaker);
//		return "branch/FindingCategoryRoom";
//	}
	
	//네비게이션바 '모임 및 이벤트
	@RequestMapping("/meetingAndEventMain")
	public String toMeetingAndEvent(Model model) throws Exception {
		model.addAttribute("mMainList", meMapper.mMainList());
		model.addAttribute("eMainList", meMapper.eMainList());
		return "event/MeetingAndEventMain";
	}
	
	//네비게이션바 '입주안내'
	@RequestMapping("/toSharingGuide")
	public String toSharingGuide() {
		return "etc/SharingGuide";
	}
	
	//네비게이션바 '고객센터'
	@RequestMapping("/toFAQ")
	public String toFAQ() {
		return "etc/FAQ";
	}
	
	//구글로그인
	@RequestMapping("/googleLogin")
	public String googleLogin() {
		return "branch/test";
	}

}
