package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;

@Mapper
public interface BranchMapper {
	
	public BranchDetailVDTO getDetail(int branchNumber);
	
	public List<RoomDTO> getRoomInfo(int branchNumber);

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);

<<<<<<< HEAD
//	public Object getPetInfo(int branchNumber);
	
=======
>>>>>>> dee268fed05aac1815253b7f7965d08272aa8c99

}
