package com.army.armytiger.command;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QnaVO {

   private Integer q_no;
   private String q_title;
   private String q_writer;
   private LocalDateTime q_regdate;
   private String q_open_yn;
   private String q_result;
   private String q_content;
   private String q_comment;
   private String military_sn;
   
   //등록화면을 위해 컬럼 추가
   private String q_email;
   private String q_phone_num;
   private String affiliation; //소속(FK).. selectKey 쓸게요..
	
}
