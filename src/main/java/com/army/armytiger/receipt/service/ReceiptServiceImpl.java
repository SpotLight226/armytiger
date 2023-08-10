package com.army.armytiger.receipt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.util.Criteria;

@Service("receiptService")
public class ReceiptServiceImpl implements ReceiptService {

	
	@Autowired
	private ReceiptMapper receiptMapper;

	@Override
	public ArrayList<TrainingVO> getRecList() {
		
		return receiptMapper.getRecList();
	}


}
