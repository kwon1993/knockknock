package com.knockknock.service;

import java.util.List;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.member.VisitDTO;



public interface BranchService {

	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO);

	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO);

	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO);

	public BranchDetailVDTO getDetail(int branchNumber);

	public List<RoomDTO> getRoomInfo(int branchNumber);

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);

	public void visitBooking(VisitDTO visitDTO);

}
