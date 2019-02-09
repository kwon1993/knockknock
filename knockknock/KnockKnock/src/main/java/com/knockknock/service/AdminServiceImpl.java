package com.knockknock.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
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
	
	//visit
	
	@Override
	public ArrayList<VisitVDTO> visitList(){
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
	public void branchRegist(String theme, String bankName, String depositor, String branchAccount, String gender,
			String introduce, String branchType, String isParking, String isElevator, String pet, String address,
			String addressDetail, String remainAddress, String publicFacility, String rule, String[] roomType) {
		int maximumResident = 0;
		for (String type : roomType) {
			switch (type) {
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
		adminMapper.branchRegist(theme, bankName, depositor, branchAccount, gender, introduce, branchType, isParking,
				isElevator, pet, address, addressDetail, publicFacility, maximumResident, rule);
	}

	@Override
	public int getBranchNumber() {
		ArrayList<Integer> branchNumber = adminMapper.getBranchNumber();
		int maxBranchNumber = Collections.max(branchNumber);
		return maxBranchNumber;
	}

	@Override
	public void roomRegist(int branchNumber, int[] roomNumber, String[] roomGender, String[] roomType,
			String[] roomSpace, int[] roomDeposit, int[] roomMonthlyRent, String[] roomRentableDate,
			String privateFacility) {
		String dateForm = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$";
		Date[] rentableDate = new Date[roomRentableDate.length];
		for(int i = 0; i < roomRentableDate.length; i++) {
			if(Pattern.matches(dateForm, roomRentableDate[i])) {
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date parsed = (java.util.Date) formatter.parse(roomRentableDate[i]);
					rentableDate[i] = new Date(parsed.getTime());
				} catch (ParseException e) {
					rentableDate[i] = null;
				}
			} else {
				rentableDate[i] = null;
			}
		}
		
		for (int i = 0; i < roomNumber.length
				&& (roomNumber[i] != 0 && roomGender[i] != "" && roomType[i] != "" && roomSpace[i] != ""
						&& roomDeposit[i] != 0 && roomMonthlyRent[i] != 0 && !(roomRentableDate[i].equals(null))); i++) {

			int allowNumber = roomType[i] == "1인실" ? 1
					: roomType[i] == "2인실" ? 2 : roomType[i] == "3인실" ? 3 : roomType[i] == "4인실" ? 4 : 0;
			adminMapper.roomRegist(branchNumber, roomNumber[i], roomGender[i], allowNumber, roomSpace[i],
					roomDeposit[i], roomMonthlyRent[i], rentableDate[i], privateFacility);
		}
	}

}
