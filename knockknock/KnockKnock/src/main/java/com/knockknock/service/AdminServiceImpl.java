package com.knockknock.service;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.member.MemberContractVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.VisitVDTO;
import com.knockknock.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminMapper adminMapper;

	// event

	@Override
	public ArrayList<EventVDTO> eventList() {
		return adminMapper.eventListView();
	}

	@Override
	public void eventWrite(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime,
			Date acceptStartTime, Date acceptEndTime, int recruitNumber) {
		adminMapper.eventWrite(memberNumber, title, content, eventStartTime, eventEndTime, acceptStartTime,
				acceptEndTime, recruitNumber);
//		ArrayList<Integer> writingNumber = adminMapper.eventWriteNumber(memberNumber, title, content, eventStartTime,
//				eventEndTime, acceptStartTime, acceptEndTime, recruitNumber);
//		Integer maxValue = Collections.max(writingNumber);
//		return maxValue;
	}

	@Override
	public EventVDTO eventView(int writingNumber) {
		adminMapper.eventViewHit(writingNumber);
		return adminMapper.eventView(writingNumber);
	}

	@Override
	public EventDTO eventModifyView(int writingNumber) {
		return adminMapper.eventModifyView(writingNumber);
	}

	@Override
	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber) {
		adminMapper.eventModify(writingNumber, memberNumber, title, content, eventStartTime, eventEndTime,
				acceptStartTime, acceptEndTime, recruitNumber);
	}

	@Override
	public void eventDelete(int writingNumber) {
		adminMapper.eventDelete(writingNumber);
	}

	// member

	@Override
	public ArrayList<MemberDTO> memberListView(String keyword) {
		return adminMapper.memberListView(keyword);
	}

	@Override
	public MemberContractVDTO memberView(int memberNumber) {
		return adminMapper.memberView(memberNumber);
	}

	@Override
	public void contractRegist(int memberNumber, int branchNumber, int roomNumber, int period, String isPet,
			String emergencyNumber, String bankName, String depositor, String memberAccount, Date contractDate,
			String idNumber, String memo) {
		int payDelayAmount = 0;
		int paneltyAmount = 0;
		int returnAmount = 0;
		adminMapper.contractRegist(memberNumber, branchNumber, roomNumber, period, isPet, emergencyNumber, bankName,
				depositor, memberAccount, contractDate, idNumber, payDelayAmount, paneltyAmount, returnAmount, memo);
	}

	@Override
	public int getContractNumber() {
		ArrayList<Integer> contractNumber = adminMapper.getContractNumber();
		int maxContractNumber = Collections.max(contractNumber);
		return maxContractNumber;
	}

	@Override
	public int getDeposit(int roomNumber, int branchNumber) {
		int deposit = adminMapper.getDeposit(roomNumber, branchNumber);
		return deposit;
	}

	@Override
	public void setReturnAmount(int contractNumber, int returnAmount) {
		adminMapper.setReturnAmount(contractNumber, returnAmount);
	}

	// visit

	@Override
	public ArrayList<VisitVDTO> visitList() {
		return adminMapper.visitListView();
	}

	@Override
	public VisitVDTO visitView(int writingNumber) {
		return adminMapper.visitView(writingNumber);
	}

	@Override
	public void visitCheck(int writingNumber) {
		adminMapper.visitCheck(writingNumber);
	}

	// Branch

	@Override
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO) {
		int maximumResident = 0;
//		List<String> allowNumber = roomDTO.getAllowNumber();
		for (int i = 0; i < roomDTO.getAllowNumber().size(); i++) {
			switch (roomDTO.getAllowNumber().get(i).toString()) {
			case "1인실":
				maximumResident += 1;
				break;
			case "2인실":
				maximumResident += 2;
				break;
			case "3인실":
				maximumResident += 3;
				break;
			case "4인실":
				maximumResident += 4;
				break;
			default:
				break;
			}
		}
		branchDTO.setMaximumResident(maximumResident);
		adminMapper.branchRegist(branchDTO);
	}

	@Override
	public int getBranchNumber() {
		ArrayList<Integer> branchNumber = adminMapper.getBranchNumber();
		int maxBranchNumber = Collections.max(branchNumber);
		return maxBranchNumber;
	}

	@Override
	public void roomRegist(int branchNumber, RoomDTO roomDTO) {
		String dateForm = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$";

//		for (int i = 0; i < roomNumber.length && (roomNumber[i] != 0 && roomGender[i] != "" && roomType[i] != ""
//				&& roomSpace[i] != "" && roomDeposit[i] != 0 && roomMonthlyRent[i] != 0
//				&& !(roomRentableDate[i].equals(null))); i++) {
//
//			int allowNumber = roomType[i] == "1인실" ? 1
//					: roomType[i] == "2인실" ? 2 : roomType[i] == "3인실" ? 3 : roomType[i] == "4인실" ? 4 : 0;
//			adminMapper.roomRegist(branchNumber, roomNumber[i], roomGender[i], allowNumber, roomSpace[i],
//					roomDeposit[i], roomMonthlyRent[i], rentableDate[i], privateFacility);
//		}

//		int roomNumberSize = roomDTO.getRoomNumber().size();
//		int roomGenderSize = roomDTO.getRoomGender().size();
//		int allowNumberSize = roomDTO.getAllowNumber().size();
//		int spaceSize = roomDTO.getSpace().size();
//		int depositSize = roomDTO.getDeposit().size();
//		int monthlyRentSize = roomDTO.getMonthlyRent().size();
//		int rentableDateSize = roomDTO.getRentableDate().size();
//
//		int[] roomNumber = new int[roomNumberSize];
//		String[] roomGender = new String[roomGenderSize];
//		String[] allowNumber = new String[allowNumberSize];
//		String[] roomSpace = new String[spaceSize];
//		int[] roomDeposit = new int[depositSize];
//		int[] roomMonthlyRent = new int[monthlyRentSize];
//		String[] roomRentableDateToString = new String[rentableDateSize];
//
//		for(int i = 0; i < roomNumberSize; i++) {
//			roomNumber[i] = roomDTO.getRoomNumber().get(i);
//			roomGender[i] = roomDTO.getRoomGender().get(i);
//			allowNumber[i] = roomDTO.getAllowNumber().get(i);
//			roomSpace[i] = roomDTO.getSpace().get(i);
//			roomDeposit[i] = roomDTO.getDeposit().get(i);
//			roomMonthlyRent[i] = roomDTO.getMonthlyRent().get(i);
//			roomRentableDateToString[i] = roomDTO.getRentableDate().get(i);
//		}

//		Date[] roomRentableDate = new Date[roomRentableDateToString.length];
//		for (int i = 0; i < roomRentableDateToString.length; i++) {
//			if (Pattern.matches(dateForm, roomRentableDateToString[i])) {
//				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//				try {
//					java.util.Date parsed = (java.util.Date) formatter.parse(roomRentableDateToString[i]);
//					roomRentableDate[i] = new Date(parsed.getTime());
//				} catch (ParseException e) {
//					roomRentableDate[i] = null;
//				}
//			} else {
//				roomRentableDate[i] = null;
//			}
//		}

//		for (int i = 0; i < roomNumber.length && (roomNumber[i] != 0 && roomGender[i] != "" && allowNumber[i] != ""
//				&& roomSpace[i] != "" && roomDeposit[i] != 0 && roomMonthlyRent[i] != 0); i++) {
//
//			adminMapper.roomRegist(branchNumber, roomNumber[i], roomGender[i], allowNumber[i], roomSpace[i],
//					roomDeposit[i], roomMonthlyRent[i], roomRentableDate[i], roomDTO.getRoomFacility());
//		}

		//String으로 받은 날짜
		Iterator<String> iterator = roomDTO.getRentableDate().iterator();
		List<Date> rentableDate = new ArrayList<Date>();

		//String으로 받은 날짜를 -> util.date -> sql.date로 변환. String -> sql.date는 잘 안되더라
		while (iterator.hasNext()) {
			String tmp = iterator.next();
			if (Pattern.matches(dateForm, tmp)) {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date parsed = (java.util.Date) formatter.parse(tmp);
					rentableDate.add(new Date(parsed.getTime()));
				} catch (ParseException e) {
					rentableDate.add(null);
				}
			} else {
				rentableDate.add(null);
			}
		}
		
		//날짜를 배열에 넣고 입력 안한 날짜는 null로 처리
		Iterator<Date> sqlDate = rentableDate.iterator();
		Date[] roomRentableDate = new Date[roomDTO.getRoomNumber().size()];
		for (int i = 0; i < roomRentableDate.length; i++) {
			if (sqlDate.hasNext()) {
				roomRentableDate[i] = sqlDate.next();
			} else {
				roomRentableDate[i] = null;
			}
		}

		//입력한 줄까지만 방 정보가 들어감. 누락된 입력란이 존재하면 입력 안됨
		for (int i = 0; i < roomDTO.getRoomNumber().size()
				&& !(roomDTO.getRoomNumber().get(i) == null || roomDTO.getDeposit().get(i) == null
						|| roomDTO.getMonthlyRent().get(i) == null || roomDTO.getRentableDate().equals(null)
						|| roomDTO.getSpace().get(i).equals(null) || roomDTO.getSpace().get(i) == ""); i++) {
			adminMapper.roomRegist(branchNumber, roomDTO.getRoomNumber().get(i), roomDTO.getRoomGender().get(i),
					roomDTO.getAllowNumber().get(i), roomDTO.getSpace().get(i), roomDTO.getDeposit().get(i),
					roomDTO.getMonthlyRent().get(i), roomRentableDate[i], roomDTO.getRoomFacility());
		}

//		private List<Integer> roomNumber;
//		private List<Integer> branchNumber;
//		private List<String> roomGender;
//		private List<String> allowNumber;
//		private List<String> space;
//		private List<Integer> deposit;
//		private List<Integer> monthlyRent;
//		private List<Date> rentableDate;
//		private String roomFacility;
////		private String imageRoom;
//		
//		private List<List<MultipartFile>> roomImages;

	}

	public void branchImageRegist(int branchNumber, BranchDTO branchDTO) {
//		DefaultResourceLoader defaultresourceloader = new DefaultResourceLoader();
//		Resource resource = defaultresourceloader.getResource("file:src/main/resource/static/" + branchNumber);
//		System.out.println(resource);
		
		String resourceToString = "src/main/resources/static/images/branch/" + branchNumber;
		
		File BranchUploadPath = new File(resourceToString);
		
		if (BranchUploadPath.exists() == false) {
			BranchUploadPath.mkdirs();
		}
		
		int Numbering = 0;
		
		for (MultipartFile multipartFile : branchDTO.getBranchImages()) {
			String extension = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
			String uploadFileName = branchNumber + "BRANCH " + ++Numbering + extension; // 브랜치넘버+파일명
			// IE에서 uploadFileName이 풀경로로 나와서, 파일명 이전 경로는 짜르는 작업. 실제 파일명이 나온다.
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("/") + 1);
			int idx = uploadFileName.indexOf(" ");
			uploadFileName = uploadFileName.substring(0, idx);

			try {
				File saveFile = new File(BranchUploadPath, uploadFileName);
				// 경로를 파일화시킨다.(실제파일생성)
				multipartFile.transferTo(saveFile);
				// DB에 저장하기 위해 상대경로명에 유저아이디를 섞은 파일명을 합쳐서 finalImage라는 DB용 경로명을 만든다.
//				String finalImage = BranchUploadFolder2 + uploadFileName;
				// 이미지경로를 저장한다.
//				memberService.saveImageDir(finalImage,username);
				// 이미지 경로를 불러온다.(뷰에서 받아 쓰기 위한 용도)
//				model.addAttribute("image",memberService.getImageDir(username));
			} catch (Exception e) {
				e.getMessage();
			} // end catch
		}
	}

	public void roomImageRegist() {

	}

	public void testBranchRegist(BranchDTO branchDTO) {
		adminMapper.testBranchRegist(branchDTO);
	}

	public void testRoomRegist(int branchNumber, String gender2, int roomNumber2, int allowNumber2, int deposit2,
			Date rentableDate2, String space2, int monthlyRent2) {
		adminMapper.testRoomRegist(branchNumber, gender2, roomNumber2, allowNumber2, deposit2, rentableDate2, space2,
				monthlyRent2);
	}

}
