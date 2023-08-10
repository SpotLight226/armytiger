package com.army.armytiger.util;

import lombok.Data;

@Data
public class Criteria {

	private int page; //조회 페이지
	private int amount; //데이터개수(페이지당)
	
	
	//검색 시 필요한 키워드
	private String searchContent; //검색어
	private String startDate; //시작 날짜
	private String endDate; //끝 날짜
	private String resResult; //응답여부
	private String searchOpt; //검색조건(작성자, 제목)
	
	
	//기본생성자(페이지 초기값)
	public Criteria() {
		this.page = 1;
		this.amount = 10;
	}
	
	//기본생성자가 아니면 값 전달 받음(2페이지 부터)
	public Criteria(int page, int amount) {
		this.page = page;
		this.amount = amount;
	}
	
	//페이지 시작을 지정하는 getter
	public int getPageStart() {
		return (page - 1) * amount;
	}
}
