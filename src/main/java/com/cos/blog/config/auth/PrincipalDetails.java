package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.domain.user.User;

import lombok.Data;
@Data
public class PrincipalDetails implements UserDetails {

	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
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
