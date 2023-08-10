package com.army.armytiger.receipt.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.army.armytiger.command.TrainingVO;

@Mapper
public interface ReceiptMapper {

	
	public ArrayList<TrainingVO> getRecList();
	
}
