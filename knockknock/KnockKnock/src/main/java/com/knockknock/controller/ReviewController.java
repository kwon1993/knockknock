package com.knockknock.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.ReviewDTO;
import com.knockknock.service.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController {

	/*
	 * @Resource ReviewService reviewService;
	 * 
	 * // 리뷰 목록
	 * 
	 * @RequestMapping("/list")
	 * 
	 * @ResponseBody private List<ReviewDTO> reviewServiceList(Model model){ return
	 * reviewService.reviewListService(); }
	 * 
	 * // 리뷰 작성
	 * 
	 * @RequestMapping("/insert")
	 * 
	 * @ResponseBody private int reviewServiceInsert(@RequestParam("branch_number")
	 * int branchNumber, @RequestParam String content) {
	 * 
	 * ReviewDTO reviewDTO = new ReviewDTO();
	 * reviewDTO.setBranchNumber(branchNumber); reviewDTO.setContent(content);
	 * 
	 * return reviewService.reviewInsertService(reviewDTO); }
	 * 
	 * // 리뷰 수정
	 * 
	 * @RequestMapping("/update")
	 * 
	 * @ResponseBody private int reviewServiceUpdate(@RequestParam int
	 * writingNumber, @RequestParam String content) { ReviewDTO reviewDTO = new
	 * ReviewDTO(); reviewDTO.setWritingNumber(writingNumber);
	 * reviewDTO.setContent(content);
	 * 
	 * return reviewService.reviewUpdateService(reviewDTO); }
	 * 
	 * 
	 * // 리뷰 삭제
	 * 
	 * @RequestMapping("/delete/{writing_number}")
	 * 
	 * @ResponseBody private int reviewServiceDelete(@PathVariable int
	 * writingNumber) {
	 * 
	 * }
	 */
}
