package com.army.armytiger.admin.service;

import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.util.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AdminMapper {
    int registForm(TrainingVO vo); // 훈련 등록

    ArrayList<TrainingVO> getList(Criteria cri); // 훈련 목록

    int getTotal(Criteria cri); // 총 개수

    TrainingVO getDetail(String t_no); // 훈련 디테일   

    int modifyForm(TrainingVO vo); // 훈련 수정

    int deleteForm(TrainingVO vo); // 훈련 삭제
     
}
