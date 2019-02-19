package com.knockknock.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.member.LikeBranchDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.security.MemberController;
import com.knockknock.service.BranchService;

@Controller
public class BranchController {
	@Autowired
	public BranchService branchService;
	@Autowired
	public MemberController mc;

	private static final Logger logger = LoggerFactory.getLogger(BranchController.class);

	// Ajax 방리스트받기(체크박스,주소)
	@RequestMapping("/roomSearch")
	@ResponseBody
	public List<BranchDetailVDTO> roomCheckbox(Model model, @RequestBody BranchDetailVDTO branchDetailVDTO) {
			model.addAttribute("list", branchService.roomList(branchDetailVDTO));
		return branchService.roomList(branchDetailVDTO);
	}
  
	  //관심사로 방찾기의 방검색
	 @RequestMapping(value="/categoryRoomSearch",method=RequestMethod.GET) 
	 @ResponseBody
	 public List<BranchDetailVDTO> categoryRoomSearch(Model model,@RequestParam(value="address") String address, @RequestParam(value="searchKeyWord[]") List<String>searchKeyWord)
	 throws Exception { 
	  
		 System.out.println(searchKeyWord +"   "+ address);
		 List<BranchDetailVDTO>  branchDetailVDTOs =branchService.categoryRoomSearch(address,searchKeyWord);
		 model.addAttribute("lists",branchDetailVDTOs);
		 System.out.println("  branchDetailVDTOs "+ branchDetailVDTOs);
	 return branchDetailVDTOs;
	 }
	 
//	@PostMapping("/categoryRoomSearch")
//	@ResponseBody
//	public List<BranchDetailVDTO>categoryRoomSearch(Model model,@RequestBody BranchDetailVDTO branchDetailVDTO)throws Exception{
//		model.addAttribute("list", branchService.categoryRoomSearch(branchDetailVDTO));
//		
//		return branchService.categoryRoomSearch(branchDetailVDTO);
//	}
	  
	 // 생년월일을 기준으로 현재 나이 계산 
	 public int getAge(int birthYear, int birthMonth, int birthDay)
	{
	        Calendar current = Calendar.getInstance();
	        int currentYear  = current.get(Calendar.YEAR);
	        int currentMonth = current.get(Calendar.MONTH) + 1;
	        int currentDay   = current.get(Calendar.DAY_OF_MONTH);
	       
	        int age = currentYear - birthYear;
	        // 생일 안 지난 경우 -1
	        if (birthMonth * 100 + birthDay > currentMonth * 100 + currentDay)  
	            age--;
	       
	        return age;
	}

	// GET: 파일 업로드 폼이 있는 페이지
	@RequestMapping(value = "roomDetailView", method = RequestMethod.GET)
	public String roomDetailView(@RequestParam("branchNumber") int branchNumber, Model model, Authentication authentication, MemberDTO memberDTO, HttpSession hs) {
		//from 성현 : 로그인시 세션유지가 안되서 테스트로 세션관련된걸 넣어놨는데 테스트 끝나면 삭제할게요
		mc.getSession(authentication,hs,memberDTO);
		
		model.addAttribute("details", branchService.getDetail(branchNumber));
		model.addAttribute("roomInfoList", branchService.getRoomInfo(branchNumber));
		model.addAttribute("memberInfoList", branchService.getMemberInfo(branchNumber));
		model.addAttribute("petInfoList", branchService.getPetInfo(branchNumber));
		
		// 해당 지점의 이미지 디렉토리에 저장되어 있는 파일 객체
		// System.getProperty("user.dir"): 프로젝트가 있는 경로까지 자동으로 가지고 옴
		String path = System.getProperty("user.dir")+"/src/main/resources/static/images/branch/"+branchNumber;
		
		File f = new File( path );
		File[] files = f.listFiles();

		// files
		int count = 0;
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < files.length-1; i++) {

		if ( files[i].isFile() ) {
		count++;
		list.add(files[i].getName());
		System.out.println( "파일 : " + files[i].getName() );
		} else {
		System.out.println( "디렉토리명 : " + files[i].getName() );
		}
		} // end of for
		System.out.println(list);
		count= count-1; // main.jpg 제외
		System.out.println("파일 갯수: " +count);
		model.addAttribute("fileList", list);

		String pathRoom = System.getProperty("user.dir")+"/src/main/resources/static/images/branch/"+branchNumber+"room";
		
		File fRoom = new File( pathRoom );
		File[] filesRoom = fRoom.listFiles();
		
		List<String> roomList = new ArrayList<String>();
		
		for(int i = 0; i < filesRoom.length-1; i++) {
		if(filesRoom[i].isFile()) {
			roomList.add(filesRoom[i].getName());
			System.out.println( "파일 : " + filesRoom[i].getName() );
		} else {
			System.out.println( "디렉토리명 : " + filesRoom[i].getName() );
		}
		}
		System.out.println(roomList);
		model.addAttribute("roomList", roomList);
		
		return "branch/HouseInfo";
	}

	/*
	 * // 업로드 폴더 생성 메서드 private String getFolder() { SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd"); Date date = new Date(); String str =
	 * sdf.format(date); return str.replace("-", File.separator); }
	 * 
	 * // 업로드 파일이 이미지 타입인지 체크하는 메서드 private boolean checkImageType(File file) { try
	 * { String contentType = Files.probeContentType(file.toPath());
	 * 
	 * return contentType.startsWith("image"); } catch (IOException e) {
	 * e.printStackTrace(); }
	 * 
	 * return false; }
	 * 
	 * @PostMapping(value="/uploadAjaxAction",
	 * produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	 * 
	 * @ResponseBody public ResponseEntity<List<AttachFileDTO>>
	 * uploadAjaxPost(MultipartFile[] uploadFile) {
	 * 
	 * List<AttachFileDTO> list = new ArrayList<>();
	 * 
	 * // 지점 번호 받아서 경로에 넣어주기! String uploadFolder =
	 * "C:\\Users\\min\\Desktop\\knockknock\\knockknock\\KnockKnock\\src\\main\\resources\\static\\images\\branch";
	 * 
	 * // 폴더 생성 String uploadFolderPath = getFolder(); File uploadPath = new
	 * File(uploadFolder, uploadFolderPath); logger.info("upload path: " +
	 * uploadPath);
	 * 
	 * if (uploadPath.exists() == false) { uploadPath.mkdirs(); }
	 * 
	 * for (MultipartFile multipartFile : uploadFile) {
	 * 
	 * AttachFileDTO attachDTO = new AttachFileDTO();
	 * 
	 * logger.info("-------------------------------");
	 * logger.info("Upload File Name: " + multipartFile.getOriginalFilename());
	 * logger.info("Upload File Size: " + multipartFile.getSize());
	 * 
	 * String uploadFileName = multipartFile.getOriginalFilename();
	 * 
	 * // IE has file path uploadFileName =
	 * uploadFileName.substring(uploadFileName.lastIndexOf("\\") + 1);
	 * logger.info("only file name: " + uploadFileName);
	 * attachDTO.setFileName(uploadFileName);
	 * 
	 * // 중복 파일 구분을 위한 랜덤 문자열 생성 UUID uuid = UUID.randomUUID();
	 * 
	 * // 언더바로 랜덤 문자열과 본래의 파일명 구분 uploadFileName = uuid.toString() + "_" +
	 * uploadFileName;
	 * 
	 * try { File saveFile = new File(uploadPath, uploadFileName);
	 * multipartFile.transferTo(saveFile);
	 * 
	 * attachDTO.setUuid(uuid.toString());
	 * attachDTO.setUploadPath(uploadFolderPath);
	 * 
	 * // 업로드 파일 타입 체크
	 * 
	 * if(checkImageType(saveFile)) { // 이미지 파일이라면 섬네일 생성
	 * 
	 * attachDTO.setImage(true);
	 * 
	 * FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,
	 * "s_"+uploadFileName));
	 * 
	 * Thumbnailator.createThumbnail(multipartFile.getInputStream(), thumbnail, 300,
	 * 300);
	 * 
	 * thumbnail.close(); }
	 * 
	 * list.add(attachDTO);
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage()); e.printStackTrace(); }
	 * }
	 * 
	 * return new ResponseEntity<>(list, HttpStatus.OK);
	 * 
	 * }
	 */

	// 방문 신청
	@RequestMapping(value = "/visitBooking", method = RequestMethod.POST)
	@ResponseBody
	public void visitBooking(@RequestBody VisitDTO visitDTO, Authentication authentication) {

		// 현재 로그인 사용자 정보에 접근
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername();

		logger.info(visitDTO.toString());
		logger.info("POST/visitBooking");

		branchService.visitBooking(visitDTO, email);
	}
	
	// 관심 지점 등록
	@RequestMapping(value="/likeBranch", method= {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public void likeBranch(@RequestBody String branchNumber1, Authentication authentication) {
		
		System.out.println("관심 지점: "+branchNumber1);
		
		int branchNumber = Integer.parseInt(branchNumber1);
		
		// 현재 로그인 사용자 정보에 접근
		authentication = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) authentication.getPrincipal();
		String email = user.getUsername();
		
		branchService.likeBranch(branchNumber, email);
	}

	/*
	 * // 업로드 파일 보여주기
	 * 
	 * @GetMapping("/display")
	 * 
	 * @ResponseBody public ResponseEntity<byte[]> getFile(String fileName) {
	 * logger.info("fileName: " + fileName);
	 * 
	 * File file = new File(
	 * "C:\\Users\\min\\Desktop\\knockknock\\knockknock\\KnockKnock\\src\\main\\resources\\static\\images\\branch"
	 * + fileName);
	 * 
	 * logger.info("file: " + file);
	 * 
	 * ResponseEntity<byte[]> result = null;
	 * 
	 * try {
	 * 
	 * HttpHeaders header = new HttpHeaders();
	 * 
	 * header.add("Content-Type", Files.probeContentType(file.toPath())); result =
	 * new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header,
	 * HttpStatus.OK); } catch (IOException e) { e.printStackTrace(); } return
	 * result; }
	 * 
	 * // 업로드 파일 다운로드
	 * 
	 * @GetMapping(value="/download", produces =
	 * MediaType.APPLICATION_OCTET_STREAM_VALUE)
	 * 
	 * @ResponseBody public ResponseEntity<Resource> downloadFile(String fileName){
	 * logger.info("download file: " + fileName); Resource resource = new
	 * FileSystemResource(
	 * "C:\\Users\\min\\Desktop\\knockknock\\knockknock\\KnockKnock\\src\\main\\resources\\static\\images\\branch\\"
	 * +fileName); logger.info("resource: " + resource);
	 * 
	 * String resourceName = resource.getFilename();
	 * 
	 * HttpHeaders headers = new HttpHeaders();
	 * 
	 * try { headers.add("Content-Disposition", "attachment; filename=" + new
	 * String(resourceName.getBytes("UTF-8"), "ISO-8859-1")); } catch
	 * (UnsupportedEncodingException e){ e.printStackTrace(); } return new
	 * ResponseEntity<Resource>(resource, headers, HttpStatus.OK); }
	 * 
	 * 
	 * // 파일 삭제
	 * 
	 * @PostMapping("/deleteFile")
	 * 
	 * @ResponseBody public ResponseEntity<String> deleteFile(String fileName,
	 * String type) { logger.info("deleteFile:" + fileName);
	 * 
	 * File file;
	 * 
	 * try { file = new File(
	 * "C:\\Users\\min\\Desktop\\knockknock\\knockknock\\KnockKnock\\src\\main\\resources\\static\\images\\branch\\"
	 * + URLDecoder.decode(fileName, "UTF-8"));
	 * 
	 * file.delete();
	 * 
	 * if (type.equals("image")) { String largeFileName =
	 * file.getAbsolutePath().replace("s_", ""); logger.info("largeFileName: " +
	 * largeFileName); file = new File(largeFileName); file.delete(); } } catch
	 * (UnsupportedEncodingException e) { e.printStackTrace(); return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } return new
	 * ResponseEntity<String>("deleted", HttpStatus.OK); }
	 */
}
