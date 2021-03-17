package com.cos.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.blog.service.AuthService;
import com.cos.blog.web.auth.dto.AuthJoinReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AuthController {
	
	private final AuthService authService;
	
	// 주소 : 인증이 안되어 있을 /user, /post,  인증이 되든 말든 옴/loginForm
	@GetMapping("/loginForm")
	public String loginForm() {
		return "auth/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}
	
	@PostMapping("/join")
	public String join(AuthJoinReqDto authJoinReqDto) {
		authService.회원가입(authJoinReqDto.toEntity());
		// 만들어 놓은 것을 재활용
		return "redirect:/loginForm";
	}
	
	
}
