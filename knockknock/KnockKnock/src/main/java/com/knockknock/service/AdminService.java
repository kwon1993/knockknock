package com.knockknock.service;

import java.sql.Date;
import java.util.ArrayList;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;

public interface AdminService {

	// event
	public ArrayList<EventVDTO> eventList();

	public void eventWrite(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime,
			Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public EventVDTO eventView(int writingNumber);

	public EventDTO eventModifyView(int writingNumber);

	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public void eventDelete(int writingNumber);

	// branch
	public void branchRegist(String theme, String bankName, String depositor, String branchAccount, String gender,
			String introduce, String branchType, String isParking, String isElevator, String pet, String address,
			String addressDetail, String remainAddress, String publicFacility, String rule, ArrayList<String> roomType);

	public int getBranchNumber();

	public void roomRegist(int branchNumber, ArrayList<Integer> roomNumber, ArrayList<String> roomGender,
			ArrayList<String> roomType, ArrayList<String> roomSpace, ArrayList<Integer> roomDeposit,
			ArrayList<Integer> roomMonthlyRent, ArrayList<Date> roomRentableDate, String privateFacility);
}
