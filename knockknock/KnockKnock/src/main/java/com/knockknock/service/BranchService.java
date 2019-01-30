package com.knockknock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchVDTO;
import com.knockknock.mapper.BranchMapper;

@Service
public class BranchService {

	@Autowired
	public BranchMapper branchMapper;
	
	public BranchVDTO getDetail(int branchNumber) {
		return branchMapper.getDetail(branchNumber);
	}
}
