package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;

@Mapper
public interface BranchMapper {
	//메인메뉴 심플방검색
	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO);
	//네비게이션바 방찾기
	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO);
	//방찾기의 방검색
	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO);
	
	public BranchDetailVDTO getDetail(int branchNumber);
	
	public List<RoomDTO> getRoomInfo(int branchNumber);

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);

//	public Object getPetInfo(int branchNumber);

}
