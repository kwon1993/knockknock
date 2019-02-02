package com.knockknock.controller;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	public AdminService adminService;

	@RequestMapping("adminBranchRegistView")
	public String adminRoomRegistView() {
		return "admin/AdminBranchRegist";
	}

	@RequestMapping("adminBranchRegist")
	public String adminRoomRegist(Model model, BranchDTO branchDTO, ArrayList<RoomDTO> roomDTO) {

		// adminService.branchRegist(branchDTO, roomDTO);

		return "admin/AdminBranchRegist";
	}

	@RequestMapping("eventListView")
	public String eventListView(Model model) {
		model.addAttribute("eventListView", adminService.eventList());
		return "admin/AdminEventList";
	}

	@RequestMapping("eventView")
	public String eventWriteView(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("eventView", adminService.eventView(writingNumber));
		return "admin/AdminEventPost";
	}

	@RequestMapping("eventWriteView")
	public String eventWriteView(Model model) {
		return "admin/AdminEventWrite";
	}

	@RequestMapping("eventWrite")
	public String eventWrite(Model model, @RequestParam("memberNumber") int memberNumber,
			@RequestParam("title") String title, @RequestParam("content") String content,
			@RequestParam("eventStartTime") Date eventStartTime, @RequestParam("eventEndTime") Date eventEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("recruitNumber") int recruitNumber) {
//		int writingNumber = 
		adminService.eventWrite(memberNumber, title, content, eventStartTime, eventEndTime, acceptStartTime,
				acceptEndTime, recruitNumber);
//		model.addAttribute("eventView", adminService.eventView(writingNumber));
//		return "redirect:admin/AdminEventPost";
		return "redirect:eventListView";
	}

	@RequestMapping("eventModifyView")
	public String eventModifyView(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("eventModifyView", adminService.eventModifyView(writingNumber));
		return "admin/AdminEventModify";
	}

	@RequestMapping("eventModify")
	public String eventModify(Model model, @RequestParam("writingNumber") int writingNumber,
			@RequestParam("memberNumber") int memberNumber, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("eventStartTime") Date eventStartTime,
			@RequestParam("eventEndTime") Date eventEndTime, @RequestParam("acceptStartTime") Date acceptStartTime,
			@RequestParam("acceptEndTime") Date acceptEndTime, @RequestParam("recruitNumber") int recruitNumber) {
		adminService.eventModify(writingNumber, memberNumber, title, content, eventStartTime, eventEndTime, acceptStartTime,
				acceptEndTime, recruitNumber);
		return "redirect:eventListView";
	}

	@RequestMapping("eventDelete")
	public String eventDelete(Model model, @RequestParam("writingNumber") int writingNumber) {
		adminService.eventDelete(writingNumber);
		return "redirect:eventListView";
	}
}
