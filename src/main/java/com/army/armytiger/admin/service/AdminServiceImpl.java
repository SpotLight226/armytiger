package com.army.armytiger.admin.service;

import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.util.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service("adminService")
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    // 훈련 등록
    @Override
    public int registForm(TrainingVO vo) {
        return adminMapper.registForm(vo);
    }

    // 훈련 목록
    @Override
    public ArrayList<TrainingVO> getList(Criteria cri) {
        return adminMapper.getList(cri);
    }

    // 총 개수
    @Override
    public int getTotal(Criteria cri) {
        return adminMapper.getTotal(cri);
    }
    
    //디테일
    @Override
    public TrainingVO getDetail(String t_no) {
        return adminMapper.getDetail(t_no);
    }

    //훈련수정
    @Override
    public int modifyForm(TrainingVO vo) {
        return adminMapper.modifyForm(vo);
    }

    // 훈련 삭제

    @Override
    public int deleteForm(TrainingVO vo) {
        return adminMapper.deleteForm(vo);
    }
}
