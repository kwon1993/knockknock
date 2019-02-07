package com.knockknock.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	Date defaultDate = null;
	@RequestMapping("adminBranchRegist")
	public String adminBranchRegist(Model model, @RequestParam("theme") String theme,
			@RequestParam("bankName") String bankName, @RequestParam("depositor") String depositor,
			@RequestParam("branchAccount") String branchAccount, @RequestParam("gender") String gender,
			@RequestParam("branchType") String branchType, @RequestParam("introduce") String introduce,
			@RequestParam("isParking") String isParking, @RequestParam("isElevator") String isElevator,
			@RequestParam("pet") String pet, @RequestParam("address") String address,
			@RequestParam("addressDetail") String addressDetail, @RequestParam("remainAddress") String remainAddress,
			@RequestParam(value = "roomNumber1", required = true, defaultValue = "0") int roomNumber1,
			@RequestParam(value = "roomNumber2", required = false, defaultValue = "0") int roomNumber2,
			@RequestParam(value = "roomNumber3", required = false, defaultValue = "0") int roomNumber3,
			@RequestParam(value = "roomNumber4", required = false, defaultValue = "0") int roomNumber4,
			@RequestParam(value = "roomNumber5", required = false, defaultValue = "0") int roomNumber5,
			@RequestParam(value = "roomNumber6", required = false, defaultValue = "0") int roomNumber6,
			@RequestParam(value = "roomNumber7", required = false, defaultValue = "0") int roomNumber7,
			@RequestParam(value = "roomNumber8", required = false, defaultValue = "0") int roomNumber8,
			@RequestParam(value = "roomGender1", required = true, defaultValue = "") String roomGender1,
			@RequestParam(value = "roomGender2", required = false, defaultValue = "") String roomGender2,
			@RequestParam(value = "roomGender3", required = false, defaultValue = "") String roomGender3,
			@RequestParam(value = "roomGender4", required = false, defaultValue = "") String roomGender4,
			@RequestParam(value = "roomGender5", required = false, defaultValue = "") String roomGender5,
			@RequestParam(value = "roomGender6", required = false, defaultValue = "") String roomGender6,
			@RequestParam(value = "roomGender7", required = false, defaultValue = "") String roomGender7,
			@RequestParam(value = "roomGender8", required = false, defaultValue = "") String roomGender8,
			@RequestParam(value = "roomType1", required = true, defaultValue = "") String roomType1,
			@RequestParam(value = "roomType2", required = false, defaultValue = "") String roomType2,
			@RequestParam(value = "roomType3", required = false, defaultValue = "") String roomType3,
			@RequestParam(value = "roomType4", required = false, defaultValue = "") String roomType4,
			@RequestParam(value = "roomType5", required = false, defaultValue = "") String roomType5,
			@RequestParam(value = "roomType6", required = false, defaultValue = "") String roomType6,
			@RequestParam(value = "roomType7", required = false, defaultValue = "") String roomType7,
			@RequestParam(value = "roomType8", required = false, defaultValue = "") String roomType8,
			@RequestParam(value = "roomSpace1", required = true, defaultValue = "") String roomSpace1,
			@RequestParam(value = "roomSpace2", required = false, defaultValue = "") String roomSpace2,
			@RequestParam(value = "roomSpace3", required = false, defaultValue = "") String roomSpace3,
			@RequestParam(value = "roomSpace4", required = false, defaultValue = "") String roomSpace4,
			@RequestParam(value = "roomSpace5", required = false, defaultValue = "") String roomSpace5,
			@RequestParam(value = "roomSpace6", required = false, defaultValue = "") String roomSpace6,
			@RequestParam(value = "roomSpace7", required = false, defaultValue = "") String roomSpace7,
			@RequestParam(value = "roomSpace8", required = false, defaultValue = "") String roomSpace8,
			@RequestParam(value = "roomDeposit1", required = true, defaultValue = "0") int roomDeposit1,
			@RequestParam(value = "roomDeposit2", required = false, defaultValue = "0") int roomDeposit2,
			@RequestParam(value = "roomDeposit3", required = false, defaultValue = "0") int roomDeposit3,
			@RequestParam(value = "roomDeposit4", required = false, defaultValue = "0") int roomDeposit4,
			@RequestParam(value = "roomDeposit5", required = false, defaultValue = "0") int roomDeposit5,
			@RequestParam(value = "roomDeposit6", required = false, defaultValue = "0") int roomDeposit6,
			@RequestParam(value = "roomDeposit7", required = false, defaultValue = "0") int roomDeposit7,
			@RequestParam(value = "roomDeposit8", required = false, defaultValue = "0") int roomDeposit8,
			@RequestParam(value = "roomMonthlyRent1", required = true, defaultValue = "0") int roomMonthlyRent1,
			@RequestParam(value = "roomMonthlyRent2", required = false, defaultValue = "0") int roomMonthlyRent2,
			@RequestParam(value = "roomMonthlyRent3", required = false, defaultValue = "0") int roomMonthlyRent3,
			@RequestParam(value = "roomMonthlyRent4", required = false, defaultValue = "0") int roomMonthlyRent4,
			@RequestParam(value = "roomMonthlyRent5", required = false, defaultValue = "0") int roomMonthlyRent5,
			@RequestParam(value = "roomMonthlyRent6", required = false, defaultValue = "0") int roomMonthlyRent6,
			@RequestParam(value = "roomMonthlyRent7", required = false, defaultValue = "0") int roomMonthlyRent7,
			@RequestParam(value = "roomMonthlyRent8", required = false, defaultValue = "0") int roomMonthlyRent8,
			@RequestParam(value = "roomRentableDate1", required = true) String roomRentableDate1,
			@RequestParam(value = "roomRentableDate2", required = false) String roomRentableDate2,
			@RequestParam(value = "roomRentableDate3", required = false) String roomRentableDate3,
			@RequestParam(value = "roomRentableDate4", required = false) String roomRentableDate4,
			@RequestParam(value = "roomRentableDate5", required = false) String roomRentableDate5,
			@RequestParam(value = "roomRentableDate6", required = false) String roomRentableDate6,
			@RequestParam(value = "roomRentableDate7", required = false) String roomRentableDate7,
			@RequestParam(value = "roomRentableDate8", required = false) String roomRentableDate8,
			@RequestParam("publicFacility") String publicFacility,
			@RequestParam("privateFacility") String privateFacility, @RequestParam("rule") String rule) {
		int[] roomNumber = { roomNumber1, roomNumber2, roomNumber3, roomNumber4, roomNumber5, roomNumber6, roomNumber7,
				roomNumber8 };
		String[] roomGender = { roomGender1, roomGender2, roomGender3, roomGender4, roomGender5, roomGender6,
				roomGender7, roomGender8 };
		String[] roomType = { roomType1, roomType2, roomType3, roomType4, roomType5, roomType6, roomType7, roomType8 };
		String[] roomSpace = { roomSpace1, roomSpace2, roomSpace3, roomSpace4, roomSpace5, roomSpace6, roomSpace7,
				roomSpace8 };
		int[] roomDeposit = { roomDeposit1, roomDeposit2, roomDeposit3, roomDeposit4, roomDeposit5, roomDeposit6,
				roomDeposit7, roomDeposit8 };
		int[] roomMonthlyRent = { roomMonthlyRent1, roomMonthlyRent2, roomMonthlyRent3, roomMonthlyRent4,
				roomMonthlyRent5, roomMonthlyRent6, roomMonthlyRent7, roomMonthlyRent8 };
		String[] roomRentableDate = { roomRentableDate1, roomRentableDate2, roomRentableDate3, roomRentableDate4,
				roomRentableDate5, roomRentableDate6, roomRentableDate7, roomRentableDate8 };
		adminService.branchRegist(theme, bankName, depositor, branchAccount, gender, introduce, branchType, isParking,
				isElevator, pet, address, addressDetail, remainAddress, publicFacility, rule, roomType);
		int branchNumber = adminService.getBranchNumber();
		adminService.roomRegist(branchNumber, roomNumber, roomGender, roomType, roomSpace, roomDeposit, roomMonthlyRent,
				roomRentableDate, privateFacility);

		System.out.println(roomRentableDate1);
		
		return "home/Home";
	}
}
