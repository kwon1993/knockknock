package com.knockknock.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.service.BranchService;

@Controller
public class BranchController {
	@Autowired
	public BranchService branchService;

	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	// Ajax 방리스트받기(체크박스,주소)
	@PostMapping("/roomSearch")
	@ResponseBody
	public List<BranchDetailVDTO> roomCheckbox(Model model, @RequestBody BranchDetailVDTO branchDetailVDTO) {
		model.addAttribute("list", branchService.roomList(branchDetailVDTO));
		return branchService.roomList(branchDetailVDTO);
	}
	//관심사로 방찾기의 방검색
	@RequestMapping("/categoryRoomSearch")
	public String categoryRoomSearch(@RequestParam("address") String address, Model model) throws Exception {
		System.out.println(address);
		
		model.addAttribute("lists", branchService.categoryRoomSearch(address));
		
		return "branch/FindingCategoryRoom";
	}

	// GET: 파일 업로드 폼이 있는 페이지
	@RequestMapping(value = "roomDetailView", method = RequestMethod.GET)
	public String roomDetailView(@RequestParam("branchNumber") int branchNumber, Model model) {
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfoList", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfo", branchService.getMemberInfo(branchNumber));

		logger.info(branchService.getMemberInfo(branchNumber).toString());

		/*
		 * // 파일 업로드 테스트 메서드 FileUploadTestForm fileUploadTestForm = new
		 * FileUploadTestForm(); model.addAttribute("fileUploadTestForm",
		 * fileUploadTestForm);
		 */

		return "branch/HouseInfo";
	}

	// 방문 신청
	@RequestMapping(value = "/visitBooking", method = RequestMethod.POST)
	@ResponseBody
	public void visitBooking(@RequestBody VisitDTO visitDTO) {
		logger.info("POST/visitBooking");
		branchService.visitBooking(visitDTO);
	}

	/*
	 * // POST: 진짜 파일 업로드 로직
	 * 
	 * @RequestMapping(value = "roomDetailView", method = RequestMethod.POST) public
	 * String uploadOneFileHandlerPOST(HttpServletRequest request, // Model model,
	 * //
	 * 
	 * @ModelAttribute("fileUploadTestForm") FileUploadTestForm fileUploadTestForm)
	 * {
	 * 
	 * return this.doUpload(request, model, fileUploadTestForm);
	 * 
	 * }
	 * 
	 * private String doUpload(HttpServletRequest request, Model model, //
	 * FileUploadTestForm fileUploadTestForm) {
	 * 
	 * String description = fileUploadTestForm.getDescription();
	 * System.out.println("Description: " + description);
	 * 
	 * // Root Directory. String uploadRootPath =
	 * request.getServletContext().getRealPath("upload");
	 * System.out.println("uploadRootPath=" + uploadRootPath);
	 * 
	 * File uploadRootDir = new File(uploadRootPath); // Create directory if it not
	 * exists. if (!uploadRootDir.exists()) { uploadRootDir.mkdirs(); }
	 * MultipartFile[] fileDatas = fileUploadTestForm.getFileDatas(); // List<File>
	 * uploadedFiles = new ArrayList<File>(); List<String> failedFiles = new
	 * ArrayList<String>();
	 * 
	 * for (MultipartFile fileData : fileDatas) {
	 * 
	 * // Client File Name String name = fileData.getOriginalFilename();
	 * System.out.println("Client File Name = " + name);
	 * 
	 * if (name != null && name.length() > 0) { try { // Create the file at server
	 * File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator +
	 * name);
	 * 
	 * BufferedOutputStream stream = new BufferedOutputStream(new
	 * FileOutputStream(serverFile)); stream.write(fileData.getBytes());
	 * stream.close(); // uploadedFiles.add(serverFile);
	 * System.out.println("Write file: " + serverFile); } catch (Exception e) {
	 * System.out.println("Error Write file: " + name); failedFiles.add(name); } } }
	 * model.addAttribute("description", description);
	 * model.addAttribute("uploadedFiles", uploadedFiles);
	 * model.addAttribute("failedFiles", failedFiles); return "branch/HouseInfo"; }
	 */
}
