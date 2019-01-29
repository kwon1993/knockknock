package com.knockknock.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.EventVDTO;

@Mapper
public interface AdminMapper {
	
	public void branchRegist(BranchDTO branchDTO, RoomDTO roomDTO);
	public ArrayList<Integer> branchNumber();
	public ArrayList<RoomDTO> roomRegist();
	public void roomModify();
	public void roomDelete();
	
	public ArrayList<EventVDTO> eventListView();
	public void eventView();
	public void eventWriteView();
	public void eventWrite();
	public void eventModifyView();
	public void eventModify();
	public void eventDelete();
	
}
