package com.army.armytiger.ajax.service;

import com.army.armytiger.command.GroundVO;

import java.util.ArrayList;

public interface AjaxService {

    ArrayList<GroundVO> getGround();

    ArrayList<GroundVO> getGroundChild1(GroundVO vo);

    ArrayList<GroundVO> getGroundChild2(GroundVO vo);

    String setImg(String g_no);
}
