package com.cos.blog.config.handler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cos.blog.config.handler.exception.MyReplyException;
import com.cos.blog.config.handler.exception.NotIdException;
import com.cos.blog.util.Script;
import com.cos.blog.web.dto.CMRespDto;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=NotIdException.class)
	public void postNotIdException(NotIdException e, HttpServletResponse httpServletResponse) {
		Script.back(httpServletResponse, e.getMessage());
	}
	
	@ExceptionHandler(value=MyReplyException.class)
	public CMRespDto<?> myReplyException(MyReplyException e) {
		return new CMRespDto<>(-1, "실패");
	}
	
	@ExceptionHandler(value=BindException.class)
	public void bindException(BindException e, HttpServletResponse httpServletResponse) {
		System.out.println("is run? BindException");
		for(FieldError error : e.getFieldErrors()) {
			System.out.println(error.getDefaultMessage());
			Script.back(httpServletResponse, error.getDefaultMessage());
			break;
		}
	}
	
	
	
}
