package com.cos.blog.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CMRespDto<T> {
	private int statusCode; // -1 :fail, 1 : success
	private T data;
}
