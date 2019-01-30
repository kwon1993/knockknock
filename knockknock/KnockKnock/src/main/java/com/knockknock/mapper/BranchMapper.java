package com.knockknock.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchVDTO;

@Mapper
public interface BranchMapper {
	
	public BranchVDTO getDetail(int branchNumber);

}
