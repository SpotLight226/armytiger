package com.army.armytiger.qna.service;

import java.util.*;

import com.army.armytiger.command.QnaVO;

public interface QnaService {


	//리스트
	ArrayList<QnaVO> getQnaList();

	//질문등록
	public int qnaRegist(QnaVO vo);

	//상세화면
	public QnaVO getQnaDetail(int q_no);
}
