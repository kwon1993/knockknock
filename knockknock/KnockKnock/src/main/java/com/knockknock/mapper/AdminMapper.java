package com.knockknock.mapper;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.dto.member.MemberContractVDTO;
import com.knockknock.dto.member.MemberDTO;
import com.knockknock.dto.member.VisitVDTO;

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
	
	//member
	
	public ArrayList<MemberDTO> memberListView(String keyword);
	
	public MemberContractVDTO memberView(int memberNumber);
	
	//visit
	
	public ArrayList<VisitVDTO> visitListView();
	
	public VisitVDTO visitView(int writingNumber);
	
	public void visitCheck(int writingNumber);

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
