package com.knockknock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchDetailVDTO;
import com.knockknock.dto.branch.RoomDTO;
import com.knockknock.mapper.BranchMapper;

@Service
public class BranchService {

	@Autowired
	public BranchMapper branchMapper;

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
	 

}
