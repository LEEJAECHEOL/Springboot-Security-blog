package com.cos.blog.web;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.blog.config.auth.PrincipalDetails;

@Controller
public class UserController {
	
	@GetMapping("/user")
	public @ResponseBody String findAll(@AuthenticationPrincipal PrincipalDetails principalDetails) { // @Controller + @ResponseBody = @RestController
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		PrincipalDetails detail = (PrincipalDetails)authentication.getPrincipal();
//		System.out.println(detail.getUser());
		System.out.println(principalDetails.getUsername());
		return "User";
	}
	
//	
//	@GetMapping({"","/"})
//	public String home() {
//		return "index"; // ViewResolver발동
//	}
}