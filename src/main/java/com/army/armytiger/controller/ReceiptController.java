package com.army.armytiger.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.receipt.service.ReceiptService;
import com.army.armytiger.util.Criteria;

@Controller
@RequestMapping("/receipt")
public class ReceiptController {

	@Autowired
	@Qualifier("receiptService")
	private ReceiptService receiptService;
	
	
	//신청 화면(검색, 리스트업)
	@GetMapping("/receiptView")
	public String receiptView(Model model) {
		
		ArrayList<TrainingVO> list = receiptService.getRecList();
		
		model.addAttribute("list", list);
		
		return "/receipt/receiptView";
	}
	
	//신청 처리(나의훈련정보?!에 insert)
	
}
 