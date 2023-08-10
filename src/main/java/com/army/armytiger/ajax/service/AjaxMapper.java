package com.army.armytiger.ajax.service;

import com.army.armytiger.command.GroundVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface AjaxMapper {

    ArrayList<GroundVO> getGround();

    ArrayList<GroundVO> getGroundChild1(GroundVO vo);

    ArrayList<GroundVO> getGroundChild2(GroundVO vo);

    String setImg(String g_no);
}
