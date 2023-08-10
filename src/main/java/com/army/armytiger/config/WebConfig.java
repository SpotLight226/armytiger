package com.army.armytiger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.army.armytiger.util.intercepter.UserAuthHandler;

@Configuration // 이거 설정파일이야
//수많은 설정을 할 수 있는 인터페이스로 구성 "WebMvcConfigurer"
public class WebConfig implements WebMvcConfigurer { // 자바 빈설정을 하기위해서 상속

	// 약간 서비스imple늘낌이네 아니면 mapper?
	// 인터셉터로 사용할 클래스를 bean
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	// 스프링설정에 인터셉터를 추가, 오버라이드에서 찾아서 오버라이딩
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		
		registry.addInterceptor(userAuthHandler()).addPathPatterns("/training/**")// user로 시작하는 모든 요청 검사
				.excludePathPatterns("/training/login") // user/login제외
				.excludePathPatterns("/") // user/login제외
				.excludePathPatterns("/training/loginForm") // 로그인메서드 제외
				.addPathPatterns("/qna/**")
				.addPathPatterns("/notice/**")
				.addPathPatterns("/receipt/**")
				.addPathPatterns("/member/**");

		// 인터셉터는 여러개가 있을 수도 있는데, 추가하면 됨.

	}
}
