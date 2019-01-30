package com.knockknock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.branch.BranchDetailVDTO;

@Controller
public class BranchController {

	@RequestMapping("/roomDetailView")
	public String roomDetailView(BranchDetailVDTO branchDetailVDTO) {
		//to 민희 : 리턴타입 지점상세로 적어서 적용해주세요
		return "forward:/";
	}
}
