package com.army.armytiger.training.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.command.TrainingInfoVO;

@Service("trainingService")
public class TrainingServiceImple implements TrainingService{
	
	@Autowired
	private TrainingMapper trainingMapper;
	
	
	//2023년 이전 훈련정보조회
	@Override
	public ArrayList<TrainingInfoVO> gettrainingInfo(String military_sn) {
		
		return trainingMapper.gettrainingInfo(military_sn);
	}
	
	//2023년 훈련정보조회
	@Override
	public ArrayList<TrainingInfoVO> gettrainingInfo2(String military_sn) {
		
		return trainingMapper.gettrainingInfo2(military_sn);
	}
	
	
	//개인정보조회
	@Override
	public ArrayList<MemberVO> getmyInfo(String military_sn) {
		
		return trainingMapper.getmyInfo(military_sn);
	}
	
	//나의정보수정 요청
	@Override
	public int myinfoUpdate(MemberVO vo) {
		
		return trainingMapper.myinfoUpdate(vo);
	}

}
