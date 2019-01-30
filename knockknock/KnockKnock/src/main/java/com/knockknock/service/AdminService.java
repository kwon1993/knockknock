package com.knockknock.service;

import java.sql.Date;
import java.util.ArrayList;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;

public interface AdminService {
	
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO);
	public ArrayList<RoomDTO> roomRegist();
	public ArrayList<EventVDTO> eventList();
	public void eventWrite(int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	public EventVDTO eventView(int writingNumber);
	public EventDTO eventModifyView(int writingNumber);
	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime, Date acceptStartTime, Date acceptEndTime, int recruitNumber);
	public void eventDelete(int writingNumber);
}
