package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.cos.blog.domain.user.User;

import lombok.Data;
@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

	private User user;
	private Map<String, Object> attributes; // OAuth 제공자로 부터 받은 회원정보
	private boolean oauth = false;
	
	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}
	
	public PrincipalDetails(User user) {
		this.user = user;
	}
	
	public PrincipalDetails(User user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
		this.oauth = true;
	}
	
	@Override
	public String getName() {
		return "몰라";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() { // 해당 계정이 만료됬는지
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { // 비밀번호5번틀릴때 락걸리는거
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 비밀번호 만료
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 활성화
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { // 권한
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		// 사용자 권한을 넣어주어야함.
//		collectors.add(new GrantedAuthority() {
//			
//			@Override
//			public String getAuthority() {
//				// TODO Auto-generated method stub
//				return user.getRole().toString();
//			}
//		});
		collectors.add(()-> "ROLE_"+user.getRole().toString());
		
		return collectors;
	}

}
