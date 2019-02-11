package com.knockknock.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.event.PageMaker;
import com.knockknock.service.MeetingAndEventServiceImpl;

@Controller
public class MeetingAndEventController {
	@Autowired
	MeetingAndEventServiceImpl meServiceImpl;
	
	@RequestMapping("/meetingList") //미팅리스트
	private String meetingList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		model.addAttribute("MeetingList", meServiceImpl.meetingListService(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(meServiceImpl.meetingCountService(cri));
		
		model.addAttribute("pageMaker", pageMaker);  // 게시판 하단의 페이징 관련, 이전페이지, 페이지 링크 , 다음 페이지
		
		return "event/MeetingList";
	}
	
	@RequestMapping("/meetingView") //미팅 상세보기
	private String meetingView(@RequestParam("writingNumber") int writingNumber, Model model) throws Exception {
		model.addAttribute("MeetingView", meServiceImpl.meetingViewService(writingNumber));
		return "event/MeetingView";
	}
	
	@RequestMapping("/writeBoardForm") //미팅 글 쓰기
	private String writeBoardForm() throws Exception{
		return "event/WriteBoard";
	}
	
	@RequestMapping("/writeBoard") //미팅 글 쓰기
	private String writeBoard(@RequestParam("memberNumber") int memberNumber, @RequestParam("title") String title,
			@RequestParam("meetingStartTime") Date meetingStartTime, @RequestParam("meetingEndTime") Date meetingEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail,
			@RequestParam("recruitMaxNumber") int recruitMaxNumber, @RequestParam("simpleIntroduce") String simpleIntroduce,
			@RequestParam("detailIntroduce") String detailIntroduce, @RequestParam("gender") String gender, 
			@RequestParam("favorite") String favorite)throws Exception{
		meServiceImpl.meetingInsertService(memberNumber, title, meetingStartTime, meetingEndTime, acceptStartTime,
				acceptEndTime, simpleIntroduce, detailIntroduce, place, placeDetail, recruitMaxNumber, gender, favorite);
		
		return "redirect:/meetingList";
	}
	
	@RequestMapping(value="/community/imageUpload", method=RequestMethod.POST)
	private void communityImageUpload(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile upload) {
        OutputStream out = null;
        PrintWriter printWriter = null;
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");		
        
        try{
        	 
            String fileName = upload.getOriginalFilename();
            byte[] bytes = upload.getBytes();
            String uploadPath = "D://gitKonckpro/knockknock/KnockKnock/src/main/resources/static/images/event" + fileName;//저장경로
 
            out = new FileOutputStream(new File(uploadPath));
            out.write(bytes);
            String callback = request.getParameter("CKEditorFuncNum");
 
            printWriter = response.getWriter();
            String fileUrl = "D://gitKonckpro/knockknock/KnockKnock/src/main/resources/static/images/event" + fileName;//url경로
 
            printWriter.println("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction("
                    + callback
                    + ",'"
                    + fileUrl
                    + "','이미지를 업로드 하였습니다.'"
                    + ")</script>");
            printWriter.flush();
 
        }catch(IOException e){
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return;
	}
	
	@RequestMapping("/meetingModifyForm")
	private String meetingModifyForm(Model model, @RequestParam("writingNumber") int writingNumber) {
		model.addAttribute("meetingModifyForm", meServiceImpl.meetingModifyFormService(writingNumber));
		return "event/meetingModify";
	}
	
	@RequestMapping("/meetingModify")
	private String meetingModify(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber,
			@RequestParam("title") String title,
			@RequestParam("meetingStartTime") Date meetingStartTime, @RequestParam("meetingEndTime") Date meetingEndTime,
			@RequestParam("acceptStartTime") Date acceptStartTime, @RequestParam("acceptEndTime") Date acceptEndTime,
			@RequestParam("place") String place, @RequestParam("placeDetail") String placeDetail,
			@RequestParam("recruitMaxNumber") int recruitMaxNumber, @RequestParam("simpleIntroduce") String simpleIntroduce,
			@RequestParam("detailIntroduce") String detailIntroduce) throws Exception{
		meServiceImpl.meetingModifyService(writingNumber, memberNumber, title, meetingStartTime, meetingEndTime,
				acceptStartTime, acceptEndTime, simpleIntroduce, detailIntroduce, place, placeDetail, recruitMaxNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/meetingDelete") //미팅 글 삭제
	private String meetingDelete(@RequestParam("writingNumber") int writingNumber) throws Exception{
		meServiceImpl.meetingDeleteService(writingNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/eventList") //이벤트 리스트
	private String eventList(@ModelAttribute("cri") Criteria cri, Model model) throws Exception{
		model.addAttribute("EventList", meServiceImpl.eventListService(cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(meServiceImpl.eventCountService(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "event/EventList";
	}
	
	@RequestMapping("/eventView") //미팅 상세보기
	private String eventView(@RequestParam("writingNumber") int writingNumber, Model model) throws Exception {
		model.addAttribute("EventView", meServiceImpl.eventViewService(writingNumber));

		return "event/EventView";
	}
	
	@RequestMapping("/mparticipate") //참가하기
	private String mparticipate(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber) throws Exception{
		meServiceImpl.mparticipateService(writingNumber, memberNumber);
		return "redirect:/meetingList";
	}
	
	@RequestMapping("/eparticipate") //참가하기
	private String eparticipate(@RequestParam("writingNumber") int writingNumber, @RequestParam("memberNumber") int memberNumber) throws Exception{
		meServiceImpl.eparticipateService(writingNumber, memberNumber);
		return "redirect:/eventList";
	}
	
	@GetMapping("/uploadAjax")
	private void uploadAjax() {
		System.err.println("upload ajax");
	}
	
	//단일 파일 업로드
//	@RequestMapping("/photoUpload")
//	public String photoUpload(HttpServletRequest request, photoUploadDTO pu, @RequestParam("memberNumber") int memberNumber) {
//		String callback = pu.getCallback();
//		String callbackFunc = pu.getCallbackFunc();
//		String fileResult = "";
//		try {
//			if(pu.getFileData() != null && pu.getFileData().getOriginalFilename() != null 
//					&& !pu.getFileData().getOriginalFilename().equals("")) {
//				//파일이 존재하면
//				String originalName = pu.getFileData().getOriginalFilename();
//				String ext = originalName.substring(originalName.lastIndexOf(".")+1);
//				//파일 기본경로
//				String defaultPath = request.getSession().getServletContext().getRealPath("/");
//				//파일 기본경로_상세경로
//				String path = defaultPath + "resource" + File.separator + "photo_upload" + File.separator;
//				File file = new File(path);
//				System.out.println("path:"+path);
//				//디렉토리 존재하지 않을경우 디렉토리 생성
//				if(!file.exists()) {
//					file.mkdirs();
//				}
//				//서버에 업로드 할 파일명(한글문제로 인해 원본파일은 올리지 않는 것이 좋다)
//				String realName = memberNumber+"_";
//				//서버에 파일 쓰기
//				pu.getFileData().transferTo(new File(path+realName));
//				fileResult += "&bNewLine=true&sFileName="+originalName+"&sFileURL=/resource/photo_upload/"+realName;
//			}else {
//				fileResult += "&errstr=error";
//			}
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "redirect:"+callback+"?callbackFunc="+callbackFunc+fileResult;
//	}
	
//	//다중 파일업로드
//	@RequestMapping("/multiplePhotoUpload")
//	@ResponseBody
//	public String multiplePhotoUpload(HttpServletRequest request) {
//		//파일정보
//		StringBuffer sb = new StringBuffer();
//		try {
//			//파일명을 받는다 - 일반 원본파일명
//			String oldName = request.getHeader("file-name");
//			//파일 기본경로_상세경로
//			String filePath = "D:/gitKonckpro/knockknock/KnockKnock/src/main/resources/static/images/event/";
//			String saveName = sb.append(new SimpleDateFormat("yyyyMMddHHmmss")
//                    .format(System.currentTimeMillis()))
//                    .append(oldName.substring(oldName.lastIndexOf("."))).toString();
//			InputStream is = request.getInputStream();
//			OutputStream os = new FileOutputStream(filePath + saveName);
//			int numRead;
//			byte b[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
//			while((numRead = is.read(b,0,b.length))!=-1) {
//				os.write(b,0,numRead);
//			}
//			os.flush();
//			os.close();
//			//정보출력
//			sb = new StringBuffer();
//            sb.append("&bNewLine=true")
//            .append("&sFileName=").append(oldName)
//            .append("&sFileURL=").append("http://localhost:1234/writeBoardForm")
//            .append(saveName);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}

}