package com.knockknock.service;

import java.sql.Date;
import java.util.ArrayList;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.member.MemberContractVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.VisitVDTO;

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
	
	//member
	public ArrayList<MemberDTO> memberListView(String keyword);
	
	public MemberContractVDTO memberView(int memberNumber);
	
	//visit
	public ArrayList<VisitVDTO> visitList();
	
	public VisitVDTO visitView(int writingNumber);
	
	public void visitCheck(int writingNumber);

	// branch
	public void branchRegist(String theme, String bankName, String depositor, String branchAccount, String gender,
			String introduce, String branchType, String isParking, String isElevator, String pet, String address,
			String addressDetail, String remainAddress, String publicFacility, String rule, String[] roomType);

	public int getBranchNumber();

	public void roomRegist(int branchNumber, int[] roomNumber, String[] roomGender,
			String[] roomType, String[] roomSpace, int[] roomDeposit,
			int[] roomMonthlyRent, String[] roomRentableDate, String privateFacility);
}
