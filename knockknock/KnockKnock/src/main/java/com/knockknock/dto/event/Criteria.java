package com.knockknock.dto.event;

import lombok.Getter;

@Getter
public class Criteria {
	private int pageNum; // 보여줄 페이지 번호
	private int amount;  // 페이지당 보여줄 게시글의 개수
	
	public Criteria(){
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		if(pageNum <= 0) {
			this.pageNum = 1;
			return;
		}
		if(amount <= 0 || amount > 100) {
			this.amount = 10;
			return;
		}	
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	public int getPageStart() {
		return (this.pageNum -1) * amount;
	}
}
