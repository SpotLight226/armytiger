package com.coding404.myweb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coding404.myweb.command.TopicVO;
import com.coding404.myweb.service.TopicService;

@Controller
@RequestMapping("/topic")
public class TopicController {
	
	@Autowired
	@Qualifier("topicService")
	private TopicService topicService;
	
	//전체 목록 화면
	@RequestMapping("/topicListAll")
	public String topicListAll(TopicVO vo, Model model) {
		
		String id = "admin";
		
		ArrayList<TopicVO> list = topicService.getList();
		model.addAttribute("list", list);
		
		return "topic/topicListAll";
	}
	
	//등록 요청
	@PostMapping("/topicRegForm")
	public String topicRegForm(TopicVO vo) {
		
		
		int result = topicService.topicReg(vo);
		System.out.println(result);
		System.out.println(vo.toString());
		
		
		return "topic/topicListAll";
	}
	
	//등록 화면
	@RequestMapping("/topicReg")
	public String topicReg() {
		
		return "topic/topicReg";
	}
	
	@RequestMapping("/topicDetail")
	public String topicDetail() {
		
		return "topic/topicDetail";
	}

}
