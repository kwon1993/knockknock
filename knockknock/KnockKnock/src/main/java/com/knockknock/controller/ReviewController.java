package com.knockknock.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.ReviewDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.service.ReviewService;

@Controller
public class ReviewController {

	@Autowired
	ReviewService reviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	// 리뷰 목록
	@PostMapping("/reviewList")
	@ResponseBody
	public List<ReviewDTO> reviewServiceList(Model model, @RequestBody String branchNumber1) {
		System.out.println(branchNumber1);
		
		 int branchNumber = Integer.parseInt(branchNumber1); 
		
		return reviewService.reviewListService(branchNumber);
		// return "test";
	}

	// 리뷰 작성
	@PostMapping("/reviewInsert")
	@ResponseBody
	private int reviewServiceInsert(@RequestBody ReviewDTO reviewDTO, Authentication authentication) {

		// RequestBody로 객체를 받아올 경우에는 아래의 코드 모두 불필요
		// ReviewDTO reviewDTO = new ReviewDTO();
		// reviewDTO.setBranchNumber(branchNumber);
		// reviewDTO.setContent(content);
		
		// 현재 로그인 사용자 정보에 접근
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername();
		
		logger.info(reviewDTO.toString());

		return reviewService.reviewInsertService(reviewDTO, email);
	}
	
	// 리뷰 수정
	@RequestMapping("/reviewUpdate")
	@ResponseBody
	private int reviewServiceUpdate(@RequestBody ReviewDTO reviewDTO) {

		// ReviewDTO reviewDTO = new ReviewDTO();
		// reviewDTO.setWritingNumber(writingNumber);
		// reviewDTO.setContent(content);
		return reviewService.reviewUpdateService(reviewDTO);
	}

	// 리뷰 삭제
	@RequestMapping("/reviewDelete/{writingNumber}")
	@ResponseBody
	private int reviewServiceDelete(@PathVariable("writingNumber") int writingNumber) {
		return reviewService.reviewDeleteService(writingNumber);
	}

}
