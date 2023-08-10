package com.army.armytiger.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.army.armytiger.command.MemberVO;
import com.army.armytiger.command.TrainingInfoVO;
import com.army.armytiger.training.service.TrainingService;


@Controller
@RequestMapping("/training")
public class TrainInfoController {
	
	
	@Autowired
	@Qualifier("trainingService")
	private TrainingService trainingService;
	
	//로그인 화면
	@GetMapping("/login")
	public String login(HttpSession session) {
		
		
		return "training/login";
	}
	
	//로그아웃 요청
		@GetMapping("/logout")
		public String logout(HttpSession session,
							 RedirectAttributes ra) {
		    
		    //로그아웃 메세지
		    String msg = "로그아웃 되었습니다! 안녕히 가십시오!";
			ra.addFlashAttribute("msg", msg);
			
			// 세션 삭제
			session.invalidate();
		    
		    return "redirect:/"; // 로그아웃 후 리다이렉트할 페이지
		}
	
		@PostMapping("/loginForm")
		public String loginForm(@RequestParam("name") String name,
		                        @RequestParam("military_sn") String military_sn,
		                        @RequestParam("password") String password,
		                        @RequestParam("grade") String grade,
		                        MemberVO vo,
		                        RedirectAttributes ra,
		                        HttpSession session) {

		    ArrayList<MemberVO> list = trainingService.getmyInfo(military_sn);
		    
		    if (!list.isEmpty()) { // 검색된 회원 정보가 있을 때
		        MemberVO member = list.get(0); // 첫 번째 MemberVO 객체 추출
		        
		        // military_sn 값을 세션에 저장
	            session.setAttribute("name", name);
	            session.setAttribute("military_sn", military_sn);
	            session.setAttribute("password", password);
	            session.setAttribute("grade", grade);
		        
		        System.out.println(session.getAttribute("name"));
	            System.out.println(session.getAttribute("military_sn"));
	            System.out.println(session.getAttribute("password"));
	            System.out.println(session.getAttribute("grade"));
		        
		        // DB에서 가져온 회원 정보와 입력한 정보를 비교
		        if (member.getName().equals(name) && 
		            member.getPassword().equals(password) &&
		            member.getMilitary_sn().equals(military_sn) &&
		            member.getGrade().equals(grade)) {

		            // military_sn 값을 세션에 저장
		            session.setAttribute("name", name);
		            session.setAttribute("military_sn", military_sn);
		            session.setAttribute("password", password);
		            session.setAttribute("grade", grade);

		            // 로그인 세션값 확인
		            System.out.println(session.getAttribute("name"));
		            System.out.println(session.getAttribute("military_sn"));
		            System.out.println(session.getAttribute("password"));
		            System.out.println(session.getAttribute("grade"));
		            
		            if(session.getAttribute("grade").equals("ADMIN")) {
		            	String msg = session.getAttribute("name") + " 관리자님 만나서 반갑습니다!";
		            	ra.addFlashAttribute("msg2", msg);
		            	return "redirect:/"; // 관리자 관리페이지로 리다이렉트 
		            }else {
		            	String msg = session.getAttribute("name") + " 예비군님 만나서 반갑습니다!";
		            	ra.addFlashAttribute("msg", msg);
		            	return "redirect:/training/trainInfo"; // 홈으로 리다이렉트
		            }

		        }
		    }
		    
		    // 로그인 실패 시 로그인 화면으로 리다이렉트
		    
			String msg = "로그인에 실패했습니다";
			ra.addFlashAttribute("msg", msg);
		    
		    return "redirect:/training/login";
		}
	
	
	//훈련정보 화면
	@GetMapping("/trainInfo")
	public String trainInfo(Model model,
							HttpSession session) {
		
		//로그인 정보
		String name = (String) session.getAttribute("name");
	    String military_sn = (String) session.getAttribute("military_sn");
	    String password = (String) session.getAttribute("password");

		//개인정보
	    ArrayList<MemberVO> list3 = trainingService.getmyInfo(military_sn);
	    model.addAttribute("list3", list3);
	    
		//2023년도 훈련조회
		ArrayList<TrainingInfoVO> list2 = trainingService.gettrainingInfo2(military_sn);
		model.addAttribute("list2", list2);
		
		//2023년도 이전 훈련조회
		ArrayList<TrainingInfoVO> list = trainingService.gettrainingInfo(military_sn);
		model.addAttribute("list", list);
		
		//클라이언트에서 넘어오는 값 확인
		System.out.println(military_sn);
		
		
		return "training/trainInfo";
	}
	
	//나의정보수정 화면
	@GetMapping("/myInfo")
	public String myInfo(Model model,
						 HttpSession session) {
		
		//String military_sn = "222222";//임시 로그인 정보 : 군번
		
		//로그인 정보
		String name = (String) session.getAttribute("name");
	    String military_sn = (String) session.getAttribute("military_sn");
	    String password = (String) session.getAttribute("password");
		
	    System.out.println(military_sn);
		
		ArrayList<MemberVO> list = trainingService.getmyInfo(military_sn);
		model.addAttribute("list", list);
		System.out.println(list.toString());
		
		return "training/myInfo";
	}
	
	//나의정보수정 요청 화면
	@PostMapping("/myinfoModi")
	public String myinfoModi(MemberVO vo, Model model, RedirectAttributes ra,
							HttpSession session) {
		//로그인 정보
		String name = (String) session.getAttribute("name");
	    String military_sn = (String) session.getAttribute("military_sn");
	    String password = (String) session.getAttribute("password");
		
		
		int result = trainingService.myinfoUpdate(vo);

		String msg = result == 1 ? "저장되었습니다" : "저장에 실패했습니다";
		ra.addFlashAttribute("msg", msg);
		
		
		return "redirect:/training/myInfo";
		
	}
	
	
	
	

}
