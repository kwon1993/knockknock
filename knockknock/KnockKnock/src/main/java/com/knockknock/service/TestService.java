package com.knockknock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.BranchTestDTO;
import com.knockknock.mapper.TestMapper;

@Service
public class TestService {
	
	@Autowired
	TestMapper testMapper;
	
	public List<BranchTestDTO> list(BranchTestDTO branchTestDTO){
		return testMapper.list(branchTestDTO);
	}
}
