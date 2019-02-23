package com.knockknock.mapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.roomVDTO;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventJoinMemberVDTO;
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
	
	public Integer getMemberNumber(String email);
	
	public EventJoinMemberVDTO getEventJoinMember(int writingNumber);

	public void eventWrite(int memberNumber, @Param("eventDTO") EventDTO eventDTO);
	
	public ArrayList<Integer> getWritingNumber();

	public ArrayList<Integer> eventWriteNumber(int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);

	public EventDTO eventModifyView(int writingNumber);

	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime,
			Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	
	public void eventCancel(int writingNumber, String cancelReason);

	public void eventDelete(int writingNumber);

	// member

	public ArrayList<MemberDTO> memberListView(String keyword);

	public MemberContractVDTO memberView(int memberNumber);

	public void contractRegist(int memberNumber, int branchNumber, int roomNumber, int period, String isPet,
			String emergencyNumber, String bankName, String depositor, String memberAccount, Date contractDate,
			String idNumber, int payDelayAmount, int paneltyAmount, int returnAmount, String memo);
	
	public ArrayList<Integer> getContractNumber();
	
	public Integer getDeposit(int roomNumber, int branchNumber);
	
	public void setReturnAmount(int contractNumber, int returnAmount);

	// visit

	public ArrayList<VisitVDTO> visitListView();

	public VisitVDTO visitView(int writingNumber);

	public void visitCheck(int writingNumber);

	// branch

	public void branchRegist(@Param("branchDTO") BranchDTO branchDTO);

	public ArrayList<Integer> getBranchNumber();

	public void roomRegist(int branchNumber, int roomNumber, String gender, String allowNumber, String roomSpace,
			int roomDeposit, int roomMonthlyRent, Date roomRentableDate, String privateFacility);

	public BranchDTO branchModifyView(int branchNumber);
	
	public List<roomVDTO> roomModifyView(int branchNumber);
	
	public void roomDelete();

	//테스트
	public void testBranchRegist(BranchDTO branchDTO);
	public void testRoomRegist(int branchNumber, String gender2, int roomNumber2, int allowNumber2, int deposit2,  Date rentableDate2, String space2, int monthlyRent2);
}
