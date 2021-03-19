package com.cos.blog.web.auth.dto;

import javax.validation.constraints.NotBlank;

import com.cos.blog.domain.user.User;

import lombok.Data;

// Valid 나중에 처리

@Data
public class AuthJoinReqDto {
	@NotBlank(message = "유저네임을 입력해주세요.")
	private String username;
	@NotBlank(message = "패스워드를 입력해주세요.")
	private String password;
	@NotBlank(message = "이메일을 입력해주세요.")
	private String email;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.email(email)
				.build();
	}
}
