package com.army.armytiger.controller;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.member.service.MemberService;
import com.army.armytiger.util.Criteria;
import com.army.armytiger.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    @Qualifier("memberService")
    private MemberService memberService;

    @GetMapping("/memberList")
    public String list(Model model, Criteria cri) {
        ArrayList<MemberVO> list = memberService.getList(cri);
        int total = memberService.getTotal(cri);

        PageVO pageVO = new PageVO(cri, total);

        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);

        return "member/memberList";
    }

    // 등록
    @GetMapping("/memberReg")
    public String memberReg() {

        return "member/memberReg";
    }

    // 등록과정
    @PostMapping("/registForm")
    public String registForm(MemberVO vo, RedirectAttributes ra) {

        vo.setPassword(vo.getPhone_num() + vo.getMilitary_sn());

        System.out.println(vo.toString());
        int result = memberService.memberRegist(vo);

        String msg = result == 1 ? "등록되었습니다" : "등록 실패, 관리자에게 문의하세요";

        ra.addFlashAttribute("msg", msg);

        return "redirect:/member/memberList";
    }

    // 상세정보
    @GetMapping("/memberDetail")
    public String memberDetail(@RequestParam("serial") String military_sn, Model model) {

        MemberVO vo = memberService.getDetail(military_sn);

        model.addAttribute("vo", vo);

        return "member/memberDetail";
    }

    // 수정하기
    @PostMapping("/modifyForm")
    public String modifyForm(MemberVO vo, RedirectAttributes ra){

        int result = memberService.memberUpdate(vo);

        String msg = result == 1 ? "수정되었습니다" : "수정 실패하였습니다. 관리자에게 문의하세요";

        ra.addFlashAttribute("msg", msg);

        return "redirect:/member/memberList";
    }

}
