package com.knockknock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.service.BranchService;

@Controller
public class BranchController {
	
	@Autowired
	public BranchService branchService;
	
	@RequestMapping("/HouseInfo")
	public String goHouseInfo(int branchNumber, Model model) {
		model.addAttribute("details", branchService.getDetail(branchNumber));
		return "branch/HouseInfo";
	}
	
	
}
