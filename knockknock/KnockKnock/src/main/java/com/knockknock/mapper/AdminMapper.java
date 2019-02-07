package com.knockknock.mapper;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;

@Mapper
public interface AdminMapper {

	// event

	public ArrayList<EventVDTO> eventListView();

	public EventVDTO eventView(int writingNumber);

	public void eventViewHit(int writingNumber);

	public void eventWrite(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime,
			Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public ArrayList<Integer> eventWriteNumber(int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public EventDTO eventModifyView(int writingNumber);

	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public void eventDelete(int writingNumber);

	// branch

	public void branchRegist(String theme, String bankName, String depositor, String branchAccount, String gender,
			String introduce, String branchType, String isParking, String isElevator, String pet, String address,
			String addressDetail, String publicFacility, int maximumResident, String rule);

	public ArrayList<Integer> getBranchNumber();

	public void roomRegist(int branchNumber, int roomNumber, String gender, int allowNumber, String roomSpace,
			int roomDeposit, int roomMonthlyRent, Date roomRentableDate, String privateFacility);

	public void roomModify();

	public void roomDelete();
}
