package com.cos.blog.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.config.handler.exception.NotIdException;
import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserRepository;
import com.cos.blog.web.user.dto.UserUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public User 회원수정(int id, UserUpdateReqDto userUpdateReqDto) {
		User userEntity = userRepository.findById(id).orElseThrow(()-> new NotIdException("존재하지 않는 아이디입니다."));
		String rawPassword = bCryptPasswordEncoder.encode(userUpdateReqDto.getPassword());
		userEntity.setPassword(rawPassword);
		userEntity.setEmail(userUpdateReqDto.getEmail());
		return userEntity;
	}// 더티체킹
}
