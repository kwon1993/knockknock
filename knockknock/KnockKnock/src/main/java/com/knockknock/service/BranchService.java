package com.knockknock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.dto.event.Criteria;
import com.knockknock.dto.member.VisitDTO;
import com.knockknock.mapper.BranchMapper;

@Service
public class BranchService {

	@Autowired
	public BranchMapper branchMapper;
	
	//네비게이션바 방찾기검색
	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO){
		return branchMapper.findingRoomList(branchDetailVDTO);
	}
	
	//네비게이션바 카테고리로 방찾기검색
	public List<BranchDetailVDTO> findingCategoryRoomList(Criteria cri) throws Exception{
		return branchMapper.findingCategoryRoomList(cri);
	}
	//카테고리로 방찾기 페이징처리
	public int categoryCountService(Criteria cri) throws Exception{
		return branchMapper.categoryCount(cri);
	}
	
	//메인화면 심플방검색
	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO){
		return branchMapper.simpleRoomSearchList(branchDetailVDTO);
	}
	//'방찾기'에서 방검색
	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO){
		return branchMapper.roomList(branchDetailVDTO);
	}
	
	public BranchDetailVDTO getDetail(int branchNumber) {
		return branchMapper.getDetail(branchNumber);
	}

	public List<RoomDTO> getRoomInfo(int branchNumber) {
		return branchMapper.getRoomInfo(branchNumber);
	}


	/*
	 * public Object getPetInfo(int branchNumber) { return
	 * branchMapper.getPetInfo(branchNumber); }
	 */

	
	 public List<BranchDetailVDTO> getMemberInfo(int branchNumber){ 
		 return branchMapper.getMemberInfo(branchNumber); }

	public void visitBooking(VisitDTO visitDTO) {
		 branchMapper.visitBooking(visitDTO);
		
	}
	 

}
