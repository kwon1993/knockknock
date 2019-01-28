package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.BranchTestDTO;

@Mapper
public interface TestMapper {
	public List<BranchTestDTO> list(BranchTestDTO branchTestDTO);
}
