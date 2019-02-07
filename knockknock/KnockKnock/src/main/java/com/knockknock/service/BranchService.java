package com.knockknock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.mapper.BranchMapper;


public interface BranchService {

	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO);

	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO);

	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO);

	public BranchDetailVDTO getDetail(int branchNumber);

	public List<RoomDTO> getRoomInfo(int branchNumber);

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);

	public void visitBooking(VisitDTO visitDTO);

}
