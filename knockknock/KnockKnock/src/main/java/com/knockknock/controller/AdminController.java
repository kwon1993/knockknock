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

	// event

	@RequestMapping("adminEventListView")
	public String eventListView(Model model) {
		model.addAttribute("eventListView", adminService.eventList());
		return "admin/AdminEventList";
	}

	@RequestMapping("adminEventView")
	public String eventWriteView(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("eventView", adminService.eventView(writingNumber));
		return "admin/AdminEventPost";
	}

	@RequestMapping("adminEventWriteView")
	public String eventWriteView(Model model) {
		return "admin/AdminEventWrite";
	}

	@RequestMapping("adminEventWrite")
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
		return "redirect:adminEventListView";
	}

	@RequestMapping("adminEventModifyView")
	public String eventModifyView(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("eventModifyView", adminService.eventModifyView(writingNumber));
		return "admin/AdminEventModify";
	}

	@RequestMapping("adminEventModify")
	public String eventModify(Model model, @RequestParam("writingNumber") int writingNumber,
			@RequestParam("memberNumber") int memberNumber, @RequestParam("title") String title,
			@RequestParam("content") String content, @RequestParam("eventStartTime") Date eventStartTime,
			@RequestParam("eventEndTime") Date eventEndTime, @RequestParam("acceptStartTime") Date acceptStartTime,
			@RequestParam("acceptEndTime") Date acceptEndTime, @RequestParam("recruitNumber") int recruitNumber) {
		adminService.eventModify(writingNumber, memberNumber, title, content, eventStartTime, eventEndTime,
				acceptStartTime, acceptEndTime, recruitNumber);
		return "redirect:adminEventListView";
	}

	@RequestMapping("adminEventDelete")
	public String eventDelete(Model model, @RequestParam("writingNumber") int writingNumber) {
		adminService.eventDelete(writingNumber);
		return "redirect:adminEventListView";
	}

	// member

	@RequestMapping("adminMemberSearch")
	public String memberSearch(Model model) {
		return "admin/AdminMemberSearch";
	}

	// question

	@RequestMapping("adminQuestionList")
	public String questionList(Model model) {
		return "admin/AdminQuestionList";
	}

	// visit

	@RequestMapping("adminVisitList")
	public String visitList(Model model) {
		return "admin/AdminVisitList";
	}

	// branch

	@RequestMapping("adminBranchRegistView")
	public String adminBranchRegistView() {
		return "admin/AdminBranchRegist";
	}

	@RequestMapping("adminBranchRegist")
	public String adminBranchRegist(Model model, @RequestParam("theme") String theme,
			@RequestParam("bankName") String bankName, @RequestParam("depositor") String depositor,
			@RequestParam("branchAccount") String branchAccount, @RequestParam("gender") String gender,
			@RequestParam("branchType") String branchType, @RequestParam("introduce") String introduce,
			@RequestParam("isParking") String isParking, @RequestParam("isElevator") String isElevator,
			@RequestParam("pet") String pet, @RequestParam("address") String address,
			@RequestParam("addressDetail") String addressDetail, @RequestParam("remainAddress") String remainAddress,
			@RequestParam("roomNumber") ArrayList<Integer> roomNumber,
			@RequestParam("roomGender") ArrayList<String> roomGender,
			@RequestParam("roomType") ArrayList<String> roomType,
			@RequestParam("roomSpace") ArrayList<String> roomSpace,
			@RequestParam("roomDeposit") ArrayList<Integer> roomDeposit,
			@RequestParam("roomMonthlyRent") ArrayList<Integer> roomMonthlyRent,
			@RequestParam("roomRentableDate") ArrayList<Date> roomRentableDate,
			@RequestParam("publicFacility") String publicFacility,
			@RequestParam("privateFacility") String privateFacility, @RequestParam("rule") String rule) {
		adminService.branchRegist(theme, bankName, depositor, branchAccount, gender, introduce, branchType, isParking,
				isElevator, pet, address, addressDetail, remainAddress, publicFacility, rule, roomType);
		int branchNumber = adminService.getBranchNumber();
		adminService.roomRegist(branchNumber, roomNumber, roomGender, roomType, roomSpace, roomDeposit, roomMonthlyRent,
				roomRentableDate, privateFacility);

		return "/";
	}
}
