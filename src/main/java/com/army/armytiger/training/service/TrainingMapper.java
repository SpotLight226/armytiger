package com.army.armytiger.training.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.command.TrainingInfoVO;

@Mapper
public interface TrainingMapper {

	//훈련정보조회
	public ArrayList<TrainingInfoVO> gettrainingInfo(String military_sn);
	//금년훈련정보조회
	public ArrayList<TrainingInfoVO> gettrainingInfo2(String military_sn);
	//나의정보조회
	public ArrayList<MemberVO> getmyInfo(String military_sn);
	//나의정보수정 요청
	public int myinfoUpdate(MemberVO vo);
}
