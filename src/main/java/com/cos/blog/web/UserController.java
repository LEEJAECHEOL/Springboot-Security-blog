package com.cos.blog.web;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.UserService;
import com.cos.blog.web.dto.CMRespDto;
import com.cos.blog.web.user.dto.UserUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService userService;
	
	@GetMapping("/user")
	public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) { // @Controller + @ResponseBody = @RestController
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails detail = (PrincipalDetails)authentication.getPrincipal();
//		System.out.println(detail.getUser());
		System.out.println(principalDetails.getUsername());
		return "User";
	}
	
	@GetMapping("/user/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "user/updateForm";
	}
	
	@PutMapping("/user/{id}")
	public @ResponseBody CMRespDto<?> update(@PathVariable int id, @RequestBody UserUpdateReqDto userUpdateReqDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		User userEntiry = userService.회원수정(id, userUpdateReqDto);
		
		// 세션수정
		// UsernamePasswordToekn -> Authentication 객체로 만들어서 -> 시큐리티 컨텍스트 홀더에 집어 넣으면 됨.
		principalDetails.setUser(userEntiry);
		
//		Authentication authentication =
//				new UsernamePasswordAuthenticationToken(userEntity.getUsername(), userEntity.getPassword());
//				SecurityContextHolder.getContext().setAuthentication(authentication);

		return new CMRespDto<>(1, null);
	}	
}