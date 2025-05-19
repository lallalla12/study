package org.hj.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	// 사용자가 클릭한 페이지번호
	private int pageNum;
	// 한 페이지당 게시물
	private int amount;
	// 어떤걸 기준으로 검색하는지(type)
	private String type;
	// 검색 키워드
	private String keyword;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
	

}
