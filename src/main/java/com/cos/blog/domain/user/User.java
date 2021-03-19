package com.cos.blog.domain.user;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "유저네임을 입력해주세요.")
	@Column(nullable = false, length = 100, unique = true)
	private String username;
	
	@NotBlank(message = "비밀번호를 입력해주세요.")
	@Column(nullable = false, length = 100)
	private String password;
	
	@NotBlank(message = "이메일을 입력해주세요.")
	@Column(nullable = false, length = 50)
	private String email;
	
	@Enumerated(EnumType.STRING)
	private RoleType role; // ADMIN, USER
	
	@CreationTimestamp
	private Timestamp createDate;
}
