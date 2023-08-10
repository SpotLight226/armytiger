package com.army.armytiger.controller;

import com.army.armytiger.admin.service.AdminService;
import com.army.armytiger.command.TrainingVO;
import com.army.armytiger.util.Criteria;
import com.army.armytiger.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class adminController {

    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    // 훈련 목록
    @GetMapping("/trainList")
    public String trainList(Model model, Criteria cri) {
        ArrayList<TrainingVO> list = adminService.getList(cri);
        int total = adminService.getTotal(cri);

        PageVO pageVO = new PageVO(cri, total);

        model.addAttribute("list", list);
        model.addAttribute("pageVO", pageVO);

        return "admin/trainList";
    }
    
    // 훈련 등록
    @GetMapping("/trainReg")
    public String trainReg() {
        return "admin/trainReg";
    }
    
    // 훈련 등록 과정
    @PostMapping("/registForm")
    public String registForm(TrainingVO vo, RedirectAttributes ra) {

        int result = adminService.registForm(vo);

        String msg = result == 1 ? "등록되었습니다" : "등록 실패, 관리자에게 문의하세요";

        ra.addFlashAttribute("msg", msg);

        return "redirect:/admin/trainList";
    }

    // 훈련 상세
    @GetMapping("/trainDetail")
    public String trainDetail(@RequestParam("serial") String t_no, Model model) {

        TrainingVO vo = adminService.getDetail(t_no);

        model.addAttribute("vo", vo);
        return "admin/trainDetail";
    }

    // 훈련 수정
    @PostMapping("/modifyForm")
    public String modifyForm(TrainingVO vo, RedirectAttributes ra) {

        int result = adminService.modifyForm(vo);

        String msg = result == 1 ? "변경되었습니다" : "변경 실패, 관리자에게 문의하세요";

        ra.addFlashAttribute("msg", msg);

        return "redirect:/admin/trainList";
    }

    @PostMapping("/deleteForm")
    public String deleteForm(TrainingVO vo, RedirectAttributes ra){

        int result = adminService.deleteForm(vo);

        String msg = result == 1 ? "삭제되었습니다" : "삭제 실패, 관리자에게 문의하세요";

        ra.addFlashAttribute("msg", msg);

        return "redirect:/admin/trainList";
    }

}
