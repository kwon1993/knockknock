package com.knockknock.mapper;

import java.sql.Date;
import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;

@Mapper
public interface AdminMapper {
	
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO);
	public ArrayList<Integer> branchNumber();
	public ArrayList<RoomDTO> roomRegist();
	public void roomModify();
	public void roomDelete();
	
	public ArrayList<EventVDTO> eventListView();
	public EventVDTO eventView(int writingNumber);
	public void eventViewHit(int writingNumber);
	public void eventWrite(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	public ArrayList<Integer> eventWriteNumber(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	public EventDTO eventModifyView(int writingNumber);
	public void eventModify(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	public void eventDelete();
	
}
