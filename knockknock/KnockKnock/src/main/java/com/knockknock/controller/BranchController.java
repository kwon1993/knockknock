package com.knockknock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {
	
	@RequestMapping("/HouseInfo")
	public String goHouseInfo() {
		return "branch/HouseInfo";
	}

}
