package com.knockknock.mapper;

import java.util.List;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;

public interface BranchMapper {
	
	public BranchDetailVDTO getDetail(int branchNumber);
	
	public List<RoomDTO> getRoomInfo(int branchNumber);

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);


}
