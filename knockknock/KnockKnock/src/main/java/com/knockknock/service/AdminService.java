package com.knockknock.service;

import java.util.ArrayList;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventVDTO;

public interface AdminService {
	
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO);
	public ArrayList<RoomDTO> roomRegist();
	public ArrayList<EventVDTO> eventList();
}
