package com.knockknock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.knockknock.dto.branch.ReviewDTO;

@Mapper
public interface ReviewMapper {

	// 리뷰 개수 카운트 for 페이징 처리
	//public int reviewCount();
	
	// 리뷰 목록
	public List<ReviewDTO> reviewList(int branchNumber);
	
	// 리뷰 작성
	public int reviewInsert(ReviewDTO reviewDTO);
	
	// 리뷰 수정
	public int reviewUpdate(ReviewDTO reviewDTO);
	
	// 리뷰 삭제
	public int reviewDelete(int writingNumber);
}
