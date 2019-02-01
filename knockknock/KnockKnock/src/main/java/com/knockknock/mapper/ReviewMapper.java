package com.knockknock.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.ReviewDTO;

@Mapper
public interface ReviewMapper {

	public int insert(ReviewDTO reviewDTO);
}
