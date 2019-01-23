package com.knockknock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BranchController {

	@RequestMapping("/")
	public String test1() {
		return "etc/layouts/Main";
	}
	
	@RequestMapping("layoutTest")
	public String test2() {
		return "branch/layoutTest";
	}
}
