package com.army.armytiger.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVO {
	
		private String military_sn; // pk
	    private String password; // 비밀번호
	    private String name; // 이름
	    private String bank; // 은행
	    private String account_no; // 계좌번호
	    private String phone_num; // 핸드폰 번호
	    private String email; // 이메일
		private String receipt_yn; // 중요메일 수신여부
	    private String contact_yn; // 수신여부
	    private String grade; // 분류
	    private String unit; // 부대
	    private String affiliation; // 소속
		private String m_rank; // 계급
		private String m_kind; //  군별
		private Integer m_history; // 연차
		private String m_yesno; // 동원 비지정
		private String m_other; // 비고
}
