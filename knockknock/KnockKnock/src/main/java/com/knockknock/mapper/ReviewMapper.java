package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.ReviewDTO;

@Mapper
public interface ReviewMapper {

	
	// 리뷰 개수
	//public int count();
	
	// 리뷰 목록
	public List<ReviewDTO> list();
	
	// 리뷰 작성
	public int insert(ReviewDTO reviewDTO);
	
	// 리뷰 수정
	public int update(ReviewDTO reviewDTO);
	
	// 리뷰 삭제
	public int delete();
}
