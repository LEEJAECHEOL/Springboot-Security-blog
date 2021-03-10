package com.cos.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // IoC 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션 
public class SecurityConfig extends WebSecurityConfigurerAdapter { // 필요한 것만 구현할려고 어댑터 사용
	
	// IoC등록만 하면 AuthenticationManager가 Bcrypt로 자동 검증해줌.
	@Bean
	public BCryptPasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
//			.antMatchers("/user", "/post").authenticated() // /user, /post 는 인증만 검사
			.antMatchers("/user", "/post").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')") // 인증, 권한 검사  ROLE은 강제성이 있음. 검증시에
			.antMatchers("/admin").access("hasRole('ROLE_ADMIN')") // 인증, 권한 검사
			.anyRequest().permitAll() // 나머지는 다 허가 해줌.
			.and()
			.formLogin() // x-www-form-urlencoded만 가능 json은 못받음
			.loginPage("/loginForm")
			.loginProcessingUrl("/login") // 스프링 시큐리티가 포스트방식에 /login이 들어오면 낚아챔.
			; 
	}
}
