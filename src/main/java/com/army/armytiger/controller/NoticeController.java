package com.army.armytiger.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.army.armytiger.command.NoticeVO;
import com.army.armytiger.notice.service.NoticeService;
import com.army.armytiger.util.Criteria;
import com.army.armytiger.util.PageVO;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	@Qualifier("noticeSerivce")
	private NoticeService noticeService;
	
	
	@GetMapping("/noticeList")
	public String noticeList(Model model, Criteria cri){
		
		String writer = "관리자";
		ArrayList<NoticeVO> list = noticeService.getList(writer, cri);
		
		int total = noticeService.getTotal(writer, cri);
		PageVO pageVO = new PageVO(cri, total);
		
		model.addAttribute("list", list);
		model.addAttribute("writer", writer);
		model.addAttribute("pageVO", pageVO);
		
		return "notice/noticeList";
	}
	
	@GetMapping("/noticeReg")
	public String noticeReg(Model model) {
		
		String writer = "관리자";
		
		model.addAttribute("writer", writer);
		
		return "notice/noticeReg";
	}
	
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam("notice_no") int notice_no, Model model) {
		
		NoticeVO vo = noticeService.getContent(notice_no);
		noticeService.getCount(notice_no);
		model.addAttribute("vo", vo);
		
		System.out.println(vo.toString());
		
		return "notice/noticeDetail";
	}
	
	@PostMapping("/registForm")
	public String registForm(NoticeVO vo, @RequestParam("file") List<MultipartFile> list) {
		
		vo.setNotice_writer("관리자");
		noticeService.regNotice(vo, list);
		
		list = list.stream().filter(t -> t.isEmpty() == false).collect(Collectors.toList());
		
		return "redirect:/notice/noticeList";
	}
	
	@GetMapping("/noticeModify")
	public String noticeModify(@RequestParam("notice_no") int notice_no, Model model) {
		
		NoticeVO vo = noticeService.getContent(notice_no);
		model.addAttribute("vo", vo);
		
		return "notice/noticeModify";
	}
	
	@PostMapping("/modifyForm")
	public String modifyForm(@RequestParam("notice_no") int notice_no, NoticeVO vo, Model model) {
		
		model.addAttribute("vo", vo);
		
		noticeService.updateNotice(vo);
		
		
		return "redirect:/notice/noticeDetail?notice_no=" + notice_no;
	}
	
	@PostMapping("/deleteForm")
	public String deleteForm(@RequestParam("notice_no") int notice_no) {
		
		noticeService.deleteNotice(notice_no);
		
		return "redirect:/notice/noticeList";
	}
}
