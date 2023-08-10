package com.army.armytiger.ajax.service;

import com.army.armytiger.command.GroundVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ajaxService")
public class AjaxServiceImpl implements AjaxService{

    @Autowired
    AjaxMapper ajaxMapper;

    // 카테고리 처음
    @Override
    public ArrayList<GroundVO> getGround() {
        return ajaxMapper.getGround();
    }

    // 하위 카테고리 경우에 따라 실행
    @Override
    public ArrayList<GroundVO> getGroundChild1(GroundVO vo) {
        return ajaxMapper.getGroundChild1(vo);
    }

    @Override
    public ArrayList<GroundVO> getGroundChild2(GroundVO vo) {
        return ajaxMapper.getGroundChild2(vo);
    }

    // 이미지 설정

    @Override
    public String setImg(String g_no) {
        return ajaxMapper.setImg(g_no);
    }
}
