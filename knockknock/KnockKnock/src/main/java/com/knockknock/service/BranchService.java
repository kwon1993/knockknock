package com.knockknock.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.member.VisitDTO;

@Service
public interface BranchService {

	// 네비게이션바 방찾기검색
	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO);

	// '관심사로 방찾기'에서 방검색
	//public List<BranchDetailVDTO> categoryRoomSearch(String address);

	// 메인화면 심플방검색
	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO);

	// '방찾기'에서 방검색
	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO);

	public BranchDetailVDTO getDetail(int branchNumber);

	public List<RoomDTO> getRoomInfo(int branchNumber);

	/*
	 * public Object getPetInfo(int branchNumber) { return
	 * branchMapper.getPetInfo(branchNumber); }
	 */

	public List<BranchDetailVDTO> getMemberInfo(int branchNumber);

	public void visitBooking(VisitDTO visitDTO);

}
