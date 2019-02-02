package com.knockknock.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.knockknock.dto.branch.ReviewDTO;
import com.knockknock.mapper.ReviewMapper;

@Service
public class ReviewService {
	
	@Resource
	ReviewMapper reviewMapper;

	public List<ReviewDTO> reviewListService() {
		return reviewMapper.list();
	}

	public int reviewInsertService(ReviewDTO reviewDTO) {
		return reviewMapper.insert(reviewDTO);
	}

	public int reviewUpdateService(ReviewDTO reviewDTO) {
		return reviewMapper.update(reviewDTO);
	}

	public int reviewDeleteService(int writingNumber) {
		return reviewMapper.delete(writingNumber);
	}

}
