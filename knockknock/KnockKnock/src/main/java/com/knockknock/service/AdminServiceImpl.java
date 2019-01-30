package com.knockknock.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventDTO;
import com.knockknock.dto.event.EventVDTO;
import com.knockknock.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	public AdminMapper adminMapper;

	@Override
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO) {
		adminMapper.branchRegist(branchDTO, roomDTO);
		ArrayList<Integer> branchNumber = adminMapper.branchNumber();
		Integer maxValue = Collections.max(branchNumber);

	}

	@Override
	public ArrayList<RoomDTO> roomRegist() {
		return null;
	}

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
	public void eventModify(int writingNumber, int memberNumber, String title, String content, Date eventStartTime, Date eventEndTime,
			Date acceptStartTime, Date acceptEndTime, int recruitNumber) {
		adminMapper.eventModify(writingNumber, memberNumber, title, content, eventStartTime, eventEndTime, acceptStartTime, acceptEndTime, recruitNumber);
	}

	@Override
	public void eventDelete(int writingNumber) {
		adminMapper.eventDelete(writingNumber);
	}


}
