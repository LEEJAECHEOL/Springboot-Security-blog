package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration // IoC 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 필요한 것만 구현할려고 어댑터 사용
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/user", "/post").authenticated() // /user, /post 는 인증이 필요하고
			.anyRequest().permitAll() // 나머지는 다 허가 해줌.
			.and()
			.formLogin() // x-www-form-urlencoded만 가능 json은 못받음
			.loginPage("/login");
	}
}
