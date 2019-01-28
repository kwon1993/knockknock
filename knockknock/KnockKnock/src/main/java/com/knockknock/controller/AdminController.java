package com.knockknock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	public AdminService adminService;
	
	@RequestMapping("adminRoomRegistView")
	public String adminRoomRegistView() {
		return "admin/AdminRoomRegistView";
	}
	
	@RequestMapping("adminRoomRegist")
	public String adminRoomRegist(Model model, BranchDTO branchDTO, ArrayList<RoomDTO> roomDTO) {
		
		//adminService.branchRegist(branchDTO, roomDTO);
		
		return "";
	}
	
	@RequestMapping("eventListView")
	public String eventListView(Model model) {
		model.addAttribute("eventListView", adminService.eventList());
		return "admin/AdminEventList";
	}
	
	@RequestMapping("eventWriteView")
	public String eventWriteView() {
		return "admin/AdminEventWrite";
	}
	
	@RequestMapping("eventWrite")
	public String eventWrite() {
		return "admin/AdminEventPost";
	}
	
	@RequestMapping("eventModifyView")
	public String eventModifyView() {
		return "admin/AdminEventModify";
	}
	
	@RequestMapping("eventModify")
	public String eventModify() {
		return "admin/AdminEventPost";
	}
	
	@RequestMapping("eventDelete")
	public String eventDelete() {
		return "admin/AdminEventList";
	}
}
