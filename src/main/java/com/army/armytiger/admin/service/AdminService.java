package com.army.armytiger.admin.service;

import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.util.Criteria;

import java.util.ArrayList;


public interface AdminService {

    // 훈련 등록
    int registForm(TrainingVO vo);

    // 훈련 목록
    ArrayList<TrainingVO> getList(Criteria cri);

    int getTotal(Criteria cri);

    // 훈련 상세
    TrainingVO getDetail(String t_no);

    // 훈련 수정
    int modifyForm(TrainingVO vo);

    // 훈련 삭제
    int deleteForm(TrainingVO vo);
}
