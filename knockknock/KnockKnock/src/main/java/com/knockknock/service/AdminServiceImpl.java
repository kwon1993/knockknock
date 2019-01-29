package com.knockknock.service;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminMapper adminMapper;

	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO) {
		adminMapper.branchRegist(branchDTO, roomDTO);
		ArrayList<Integer> branchNumber = adminMapper.branchNumber();
		Integer maxValue = Collections.max(branchNumber);
		
	}

	public ArrayList<RoomDTO> roomRegist() {
		return null;
	}

	public ArrayList<EventVDTO> eventList() {
		return adminMapper.eventListView();
	}
	
	
	

}
