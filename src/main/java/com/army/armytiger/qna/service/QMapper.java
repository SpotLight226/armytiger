package com.army.armytiger.qna.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.army.armytiger.command.QnaVO;

@Mapper
public interface QMapper {
	//@Select(value = "select * from qna")
	public ArrayList<QnaVO> abc();
	
	//질문등록
	public int qnaRegist(QnaVO vo);
	
	//상세화면
	public QnaVO getQnaDetail(int q_no);
}
