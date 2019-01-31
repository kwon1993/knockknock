package com.knockknock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.knockknock.service.BranchService;


@Controller
public class BranchController {
	
	@Autowired
	public BranchService branchService;
	
	private static final Logger logger=LoggerFactory.getLogger(BranchController.class);
	
	@RequestMapping("HouseInfo")
	public String roomDetailView(@RequestParam("branch_number") int branchNumber, Model model) {
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfo", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfo", branchService.getMemberInfo(branchNumber));
		logger.info(branchService.getMemberInfo(branchNumber).toString());
//		model.addAttribute("petInfo", branchService.getPetInfo(branchNumber));
		return "branch/HouseInfo";
	}
}
