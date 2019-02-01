package com.knockknock.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.fileUploadTest.FileUploadTestForm;
import com.knockknock.service.BranchService;

@Controller
public class BranchController {

	@Autowired
	public BranchService branchService;
	
	private static final Logger logger=LoggerFactory.getLogger(BranchController.class);
	
	// GET: 파일 업로드 폼이 있는 페이지
	@RequestMapping(value="HouseInfo", method=RequestMethod.GET)
	public String roomDetailView(@RequestParam("branch_number") int branchNumber, Model model) {
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfo", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfo", branchService.getMemberInfo(branchNumber));
		logger.info(branchService.getMemberInfo(branchNumber).toString());
		
	
		// 파일 업로드 테스트 메서드
		FileUploadTestForm fileUploadTestForm = new FileUploadTestForm();
		model.addAttribute("fileUploadTestForm", fileUploadTestForm);
		
		return "branch/HouseInfo";
	}
	

	   // POST: 진짜 파일 업로드 로직
	   @RequestMapping(value = "HouseInfo", method = RequestMethod.POST)
	   public String uploadOneFileHandlerPOST(HttpServletRequest request, //
	         Model model, //
	         @ModelAttribute("fileUploadTestForm") FileUploadTestForm fileUploadTestForm) {
	 
	      return this.doUpload(request, model, fileUploadTestForm);
	 
	   }
	   
	   private String doUpload(HttpServletRequest request, Model model, //
			   FileUploadTestForm fileUploadTestForm) {
		 
		      String description = fileUploadTestForm.getDescription();
		      System.out.println("Description: " + description);
		 
		      // Root Directory.
		      String uploadRootPath = request.getServletContext().getRealPath("upload");
		      System.out.println("uploadRootPath=" + uploadRootPath);
		 
		      File uploadRootDir = new File(uploadRootPath);
		      // Create directory if it not exists.
		      if (!uploadRootDir.exists()) {
		         uploadRootDir.mkdirs();
		      }
		      MultipartFile[] fileDatas = fileUploadTestForm.getFileDatas();
		      //
		      List<File> uploadedFiles = new ArrayList<File>();
		      List<String> failedFiles = new ArrayList<String>();
		 
		      for (MultipartFile fileData : fileDatas) {
		 
		         // Client File Name
		         String name = fileData.getOriginalFilename();
		         System.out.println("Client File Name = " + name);
		 
		         if (name != null && name.length() > 0) {
		            try {
		               // Create the file at server
		               File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
		 
		               BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		               stream.write(fileData.getBytes());
		               stream.close();
		               //
		               uploadedFiles.add(serverFile);
		               System.out.println("Write file: " + serverFile);
		            } catch (Exception e) {
		               System.out.println("Error Write file: " + name);
		               failedFiles.add(name);
		            }
		         }
		      }
		      model.addAttribute("description", description);
		      model.addAttribute("uploadedFiles", uploadedFiles);
		      model.addAttribute("failedFiles", failedFiles);
		      return "branch/HouseInfo";
		   }
}
