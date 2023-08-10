package com.army.armytiger.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.army.armytiger.command.QnaVO;
import com.army.armytiger.qna.service.QnaService;

@Controller
@RequestMapping("/qna")
public class QnaController {
	
	@Autowired
	@Qualifier("qnaService")
	private QnaService qnaService;
	

	//목록화면
	@GetMapping("/qnaList")
	public String qnaList(Model model) {
		
		 ArrayList<QnaVO> list = qnaService.getQnaList();
		
		System.out.println(list.toString());
		
	
		model.addAttribute("list", list);
		
		
		return "/qna/qnaList";
	}
	
	//등록화면
	@GetMapping("/qnaReg")
	public String qnaReg() {
		return "/qna/qnaReg";
	}
	
	//등록처리
	@PostMapping("/xxa")
	public String qna_regForm(QnaVO vo, RedirectAttributes ra) {
		
		int result = qnaService.qnaRegist(vo);
		
		String msg = result == 1 ? "질문이 등록되었습니다" : "등록실패 다시 등록해주십시오";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/qna/qnaList";
		
	}
	
	
	//신청결과(수정삭제) 화면
	@GetMapping("/qnaResult")
	public String qnaResult(@RequestParam("q_no") int q_no,
							Model model) {
		
		QnaVO vo = qnaService.getQnaDetail(q_no);
		
		System.out.println(vo.toString());
		
		model.addAttribute("vo", vo);
		
		return "qna/qnaResult";
	}
	
	
	//수정
	@PostMapping("/qnaModifyForm")
	public String qnaModifyForm(QnaVO vo, Model model, RedirectAttributes ra) {
		
		
		return "redirect:/qna/qnaList";
	}
	
	//삭제
	@PostMapping("/qnaDeleteForm")
	public String qnaDeleteForm(QnaVO vo,
								Model model, RedirectAttributes ra) {
		return "redirect:/qna/qnaList";
	}
	
	
}
