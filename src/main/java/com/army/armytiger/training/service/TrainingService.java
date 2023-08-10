package com.army.armytiger.training.service;

import java.util.ArrayList;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.command.TrainingInfoVO;

public interface TrainingService {
	
	//2023년 이전 훈련정보조회
	public ArrayList<TrainingInfoVO> gettrainingInfo(String military_sn);
	//2023년 훈련정보조회
	public ArrayList<TrainingInfoVO> gettrainingInfo2(String military_sn);
	//나의정보조회
	public ArrayList<MemberVO> getmyInfo(String military_sn);
	//나의정보수정 요청
	public int myinfoUpdate(MemberVO vo);
	
}
