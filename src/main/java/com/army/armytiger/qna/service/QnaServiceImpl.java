package com.army.armytiger.qna.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.army.armytiger.command.QnaVO;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {

	@Autowired
	private QMapper qMapper;


	//질문등록
	@Override
	public int qnaRegist(QnaVO vo) {
		
		return qMapper.qnaRegist(vo);
	}

	
	//리스트
	@Override
	public ArrayList<QnaVO> getQnaList() {
//		System.out.println(111);
		return qMapper.abc();
	}


	@Override
	public QnaVO getQnaDetail(int q_no) {
		
		return qMapper.getQnaDetail(q_no);
	}



	
	

}
