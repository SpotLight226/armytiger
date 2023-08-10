package com.army.armytiger.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class UserAuthHandler implements HandlerInterceptor{

	//컨트롤러 진입하기 직전에 실행됨
	//return true가 들어가면 컨트롤러가 실행됨
	//return false가 들어가면 컨트롤러 실행x
	//메서드 코드 만든 후 -> 스프링설정파일에 인터셉터를 등록
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("userAuthHandler 동작함");
		System.out.println("======================>");
		
		//세션검사
		HttpSession session = request.getSession();
		
		if(session.getAttribute("military_sn") != null) {//로그인이 된 사람
			System.out.println(session.getAttribute("military_sn"));
			return true;
		
		}else {//로그인이 안되어 있는 경우
			
			response.sendRedirect(request.getContextPath() + "/training/login");
			return false;
		}
		
	}

	//컨트롤러 실행후에 동작함
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
		//모델엔 뷰를 사용해서 컨트롤러에서 돌아오는 모델데이터 or 뷰의 정보 확인
		System.out.println("userAuthHandler post핸들러 동작함");
		System.out.println("=============================>");
	}

	
	
	
}

