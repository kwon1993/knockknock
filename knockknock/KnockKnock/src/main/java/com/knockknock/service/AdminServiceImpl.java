package com.knockknock.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
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

	// Branch

	@Override
	public void branchRegist(String theme, String bankName, String depositor, String branchAccount, String gender,
			String introduce, String branchType, String isParking, String isElevator, String pet, String address,
			String addressDetail, String remainAddress, String publicFacility, String rule, ArrayList<String> roomType) {
		int maximumResident = 0;
		for (String type : roomType) {
			switch(type){
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
	public void roomRegist(int branchNumber, ArrayList<Integer> roomNumber, ArrayList<String> roomGender,
			ArrayList<String> roomType, ArrayList<String> roomSpace, ArrayList<Integer> roomDeposit,
			ArrayList<Integer> roomMonthlyRent, ArrayList<Date> roomRentableDate, String privateFacility) {
		Iterator<Integer> number = roomNumber.iterator();
		Iterator<String> gender = roomGender.iterator();
		Iterator<String> type = roomType.iterator();
		Iterator<String> space = roomSpace.iterator();
		Iterator<Integer> deposit = roomDeposit.iterator();
		Iterator<Integer> monthlyRent = roomMonthlyRent.iterator();
		Iterator<Date> rentableDate = roomRentableDate.iterator();
		while(number.hasNext() && gender.hasNext() && type.hasNext() && space.hasNext() && deposit.hasNext() && monthlyRent.hasNext() && rentableDate.hasNext()) {
			String typeNumber = type.next();
			int allowNumber = typeNumber == "1인실" ? 1 : typeNumber == "2인실" ? 2 : typeNumber == "3인실" ? 3 : typeNumber == "4인실" ? 4 : 0;
			adminMapper.roomRegist(branchNumber, number.next(), gender.next(), allowNumber, space.next(), deposit.next(), monthlyRent.next(), rentableDate.next(), privateFacility);
		}
	}

}
