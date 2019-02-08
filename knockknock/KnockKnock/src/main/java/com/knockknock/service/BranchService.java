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

	// 네비게이션바 방찾기검색
	public List<BranchDetailVDTO> findingRoomList(BranchDetailVDTO branchDetailVDTO) {
		return branchMapper.findingRoomList(branchDetailVDTO);
	}

	// 메인화면 심플방검색
	public List<BranchDetailVDTO> simpleRoomSearchList(BranchDetailVDTO branchDetailVDTO) {
		return branchMapper.simpleRoomSearchList(branchDetailVDTO);
	}

	// '방찾기'에서 방검색
	public List<BranchDetailVDTO> roomList(BranchDetailVDTO branchDetailVDTO) {
		return branchMapper.roomList(branchDetailVDTO);
	}

	//네비게이션바 관심사로 방찾기검색
	public List<BranchDetailVDTO> findingCategoryRoomList(Criteria cri) throws Exception{
		return branchMapper.findingCategoryRoomList(cri);
	}
	
	//관심사로 방찾기 페이징처리
	public int categoryCountService(Criteria cri) throws Exception{
		return branchMapper.categoryCount(cri);
	}
	
	// 지점 상세 정보 - 상세
	public BranchDetailVDTO getDetail(int branchNumber) {
		return branchMapper.getDetail(branchNumber);
	}

	// 지점 상세 정보 - 방
	public List<RoomDTO> getRoomInfo(int branchNumber) {
		return branchMapper.getRoomInfo(branchNumber);
	}

	// 지점 상세 정보 - 입주민
	public List<BranchDetailVDTO> getMemberInfo(int branchNumber) {
		return branchMapper.getMemberInfo(branchNumber);
	}
	
	// 방문 신청
	public void visitBooking(VisitDTO visitDTO) {
		branchMapper.visitBooking(visitDTO);
	}

}
